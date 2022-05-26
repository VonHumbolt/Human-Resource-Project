package com.kaankaplan.humanresources.services.interfaces;

import com.kaankaplan.humanresources.models.Employee;
import com.kaankaplan.humanresources.models.HumanResourceUser;

public interface AuthService {

	void register(HumanResourceUser humanResourceUser);
	
	void register(Employee employee);
}
