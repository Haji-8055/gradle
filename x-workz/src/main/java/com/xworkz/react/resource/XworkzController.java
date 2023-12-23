package com.xworkz.react.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.react.dto.XworkzDTO;

@RestController
@RequestMapping("/")
public class XworkzController {

	@GetMapping(value = "/run")
	public ResponseEntity<String> testRun() {

		return new ResponseEntity<String>("running test method", HttpStatus.ACCEPTED);

	}

	@PostMapping(value = "/employee")
	public ResponseEntity<String> saveEmployee(@RequestBody XworkzDTO dto) {
		
		System.out.println("employee data from react : " +dto);

		return new ResponseEntity<String>("employee data from react : "+dto, HttpStatus.ACCEPTED);

	}
}
