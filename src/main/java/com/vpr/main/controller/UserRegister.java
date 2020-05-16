package com.vpr.main.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vpr.main.model.Register;
import com.vpr.main.service.RegisterService;

@RestController
@CrossOrigin(origins="*")
public class UserRegister {

	@Autowired 
	private RegisterService registerService;
	
	@PostMapping("/users")
	public String  addtopic(@Valid @RequestBody Register  register) {  
		registerService.userRegister(register);
		 return " save success";
	}
	
}
