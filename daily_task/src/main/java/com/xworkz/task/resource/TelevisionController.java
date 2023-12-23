package com.xworkz.task.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.task.dto.TelevisionDTO;
import com.xworkz.task.service.TelevisionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TelevisionController {

	@Autowired
	TelevisionService service;

	@GetMapping(value = "/readAll",produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TelevisionDTO>> findAll() {
		log.info("running findAll in TelevisionController....................");

		List<TelevisionDTO> dtos = service.findAll();
		System.out.println(dtos);
				

		return ResponseEntity.ok(dtos);

	}
	
	
	@PostMapping(value = "/upload")
	public ResponseEntity<String> getExcelSheet(@RequestParam("sheet") MultipartFile sheet) {
		log.info("running getExcelSheet inside TelevisionController......" );
		if (!sheet.isEmpty()) {
			service.saveExcel(sheet);
			return new ResponseEntity<String>("form submitted successFully", HttpStatus.ACCEPTED);


		}else
			
			
			return new ResponseEntity<String>("please upload excelSheet", HttpStatus.ACCEPTED);
		
		
		
		
	}

}
