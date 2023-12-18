package com.xworkz.task.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.task.dto.TelevisionDTO;
import com.xworkz.task.entity.TelevisionEntity;
import com.xworkz.task.repository.TelevisionRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TelevisionServiceImpl implements TelevisionService {

	@Autowired
	TelevisionRepo repo;

	@Override
	public List<TelevisionDTO> findAll() {
		log.info("running findAll in TelevisionServiceImpl....................");

		List<TelevisionEntity> list = repo.findAll();

		List<TelevisionDTO> dtos = new ArrayList<>();

		for (TelevisionEntity entity : list) {

			TelevisionDTO dto = new TelevisionDTO();
			BeanUtils.copyProperties(entity, dto);

			dtos.add(dto);

		}

		return dtos;
	}

	public List<TelevisionEntity> excelToEntity(InputStream inputStream) {
		log.info("running  excelToEntity to convert excel data to entity......" );

		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheetAt(0);
			List<TelevisionEntity> list = new ArrayList<>();

			int rowIndex=0;
			for (Row row : sheet) {
				if (rowIndex==0) {
					rowIndex++;
					continue;
					
				}

				TelevisionEntity entity = new TelevisionEntity();

				entity.setBrand(row.getCell(0).getStringCellValue());
				System.out.println(row.getCell(0).getStringCellValue());
				entity.setInfo(row.getCell(1).getStringCellValue());
				entity.setPrice(row.getCell(2).getNumericCellValue());
				entity.setPic_name(row.getCell(3).getStringCellValue());
				list.add(entity);

			}

			return list;
//			 Iterator<Row> rows = sheet.iterator();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean saveExcel(MultipartFile sheet) {
		log.info("running saveExcel inside TelevisionServiceImpl......" );

		try {
			log.info("calling excelToEntity to convert excel data to entity......" );

			List<TelevisionEntity> list = excelToEntity(sheet.getInputStream());
			repo.saveAll(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
