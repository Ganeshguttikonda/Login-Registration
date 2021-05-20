package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Registration;
import com.capgemini.exception.RegistrationException;
import com.capgemini.repository.IRegistrationRepository;

@Service
public class RegistrationServiceImpl implements IRegistrationService  {
	
	@Autowired
	private IRegistrationRepository iRegistrationRepository;

	@Override
	public String employeeRegistration(Registration registration) throws RegistrationException {
	registration.setRole("employee");
	if(!(registration.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))){
		throw new RegistrationException("Give valid Email");
	}
	if(!(registration.getPassword().matches("^[A-Za-z0-9@.*#$!]{6,10}$"))) {
		throw new RegistrationException("Give valid password");
	}
	iRegistrationRepository.save(registration);
		return "Employee Registration Successful";
	}

	@Override
	public String UserRegistration(Registration registration) throws RegistrationException {
		
		if(!(registration.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))){
			throw new RegistrationException("Give valid Email");
		}
		if(!(registration.getPassword().matches("^[A-Za-z0-9@.*#$!]{6,10}$"))) {
			throw new RegistrationException("Give valid password");
		}
		registration.setRole("user");
		iRegistrationRepository.save(registration);
			return "User Registration Successful";
	}



}
