package com.kaankaplan.humanresources.services.interfaces;

import com.kaankaplan.humanresources.models.HumanResourceUser;

public interface HumanResourceUserService {
	
	void add(HumanResourceUser user);
	
	void delete(int userId);

}
