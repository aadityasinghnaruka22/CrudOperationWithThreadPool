package com.ebit.poolthreadCode.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebit.poolthreadCode.entity.User;
import com.ebit.poolthreadCode.service.UserService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/uploaddata")
	public List<User> uploadCsvData(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			// create csv bean reader
			CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader).withType(User.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			// convert `CsvToBean` object to list of users
			List<User> users = csvToBean.parse();
			userService.saveUsersInChunks(users);
			System.out.println("done");

			return users;

		} catch (Exception ex) {
			ex.printStackTrace(); // Log the exception
		}
		return null;

	}
}
