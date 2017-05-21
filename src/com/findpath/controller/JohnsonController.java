package com.findpath.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.findpath.dao.JohnsonsAlgorithm;
import com.findpath.model.*;

@RestController
public class JohnsonController {
	
	@Autowired
	private JohnsonsAlgorithm JohnsonsAlgorithmDAO;
	
	@RequestMapping("/")
	public String index() {
		return "Welcome to RestTemplate Example.";
	}
	@CrossOrigin
	@PostMapping(value = "/johnson", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody JohnsonAlgorithmMODEL findPath(@RequestBody JohnsonAlgorithmMODEL johnsonAlgorithmMODEL) {
		try {
			johnsonAlgorithmMODEL.initAdjacencyMatrix();
			johnsonAlgorithmMODEL.initJohnsonsAlgorithm();
			JohnsonsAlgorithmDAO.johnsonsAlgorithms(johnsonAlgorithmMODEL);
			return johnsonAlgorithmMODEL;
		} catch (NumberFormatException nfe) {
			System.out.println("Dữ liệu không hơp lệ");
			
		}
		return null;
	}
}
