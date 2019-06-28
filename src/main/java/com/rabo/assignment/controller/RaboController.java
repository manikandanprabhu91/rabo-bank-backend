package com.rabo.assignment.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rabo.assignment.pojo.RaboRecordResponse;
import com.rabo.assignment.utils.RaboUtil;

@RestController
@RequestMapping(value = "/api/repo/assignment/v1/auth")
public class RaboController {
	
	@Autowired
	RaboUtil reboUtil;

	@PostMapping("/rebo-file-upload")
	public ResponseEntity<?> csvfileUpload(@RequestParam("file") MultipartFile file, 
			HttpServletResponse response) throws IOException {
		RaboRecordResponse reboResponse = reboUtil.loadAndValidateData(file);
		response.addHeader("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<RaboRecordResponse>(reboResponse, HttpStatus.OK);
	}

	
	
}