package com.xworkz.task.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class ImageController {

	public ImageController() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@GetMapping("/display")
	public void displayImage(HttpServletResponse response, @RequestParam String fileName) throws IOException {
		log.info("running displayImage................");
//		Path path = Paths.get("F:\\televison-images\\" + fileName);
//		path.toFile();
		response.setContentType("image/jpeg");
		File file = new File("F:\\televison-images\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
	}
}
