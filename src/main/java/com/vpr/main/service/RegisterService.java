package com.vpr.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpr.main.model.Register;
import com.vpr.main.repository.RegisterRepository;

@Service
@Transactional
public class RegisterService  {
	
	@Autowired 
	private RegisterRepository registerRepository;
	
	public void userRegister(Register register) {
		registerRepository.save(register);
		
	}
	
}
