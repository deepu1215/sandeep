package com.example.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.dao.RegistrationDao;
import com.example.model.Registration;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService
{
	private RegistrationDao registrationDao;
	
	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	public void addRegistration(Registration reg)
	{
		registrationDao.addRegistartion(reg);
	}
}
