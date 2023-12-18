package com.xworkz.task.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.task.dto.TelevisionDTO;

public interface TelevisionService {
	
	 List<TelevisionDTO> findAll();
	 
	 boolean saveExcel(MultipartFile  sheet);

}
