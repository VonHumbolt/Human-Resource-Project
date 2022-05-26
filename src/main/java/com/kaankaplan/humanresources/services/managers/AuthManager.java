package com.kaankaplan.humanresources.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankaplan.humanresources.models.Employee;
import com.kaankaplan.humanresources.models.HumanResourceUser;
import com.kaankaplan.humanresources.services.interfaces.AuthService;
import com.kaankaplan.humanresources.services.interfaces.EmployeeService;
import com.kaankaplan.humanresources.services.interfaces.HumanResourceUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthManager implements AuthService{

	private EmployeeService employeeService;
	private HumanResourceUserService humanResourceUserService;
	
	@Autowired
	public AuthManager(EmployeeService employeeService, HumanResourceUserService humanResourceUserService) {
		super();
		this.employeeService = employeeService;
		this.humanResourceUserService = humanResourceUserService;
	}

	@Override
	public void register(HumanResourceUser humanResourceUser) {
		log.info("İnsan kaynakları yöneticisi kaydedildi....");
		this.humanResourceUserService.add(humanResourceUser);
		
	}

	@Override
	public void register(Employee employee) {
		
		log.info("Çalışan kaydedildi....");
		
		this.employeeService.add(employee);
		
	}

}
