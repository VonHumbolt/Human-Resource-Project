package com.kaankaplan.humanresources.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaankaplan.humanresources.dao.HumanResourceUserDao;
import com.kaankaplan.humanresources.models.HumanResourceUser;
import com.kaankaplan.humanresources.models.OperationClaim;
import com.kaankaplan.humanresources.models.User;
import com.kaankaplan.humanresources.services.interfaces.HumanResourceUserService;
import com.kaankaplan.humanresources.services.interfaces.OperationClaimService;
import com.kaankaplan.humanresources.services.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HumanResourceUserManager implements HumanResourceUserService{

	private HumanResourceUserDao humanResourceUserDao;
	private UserService userService;
	private OperationClaimService operationClaimService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public HumanResourceUserManager(HumanResourceUserDao humanResourceUserDao, UserService userService,
			OperationClaimService operationClaimService, PasswordEncoder passwordEncoder) {
		super();
		this.humanResourceUserDao = humanResourceUserDao;
		this.userService = userService;
		this.operationClaimService = operationClaimService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void add(HumanResourceUser user) {

		log.info("Admin eklendi");
		
		User humanResourceUser = this.userService.getUserByEmail(user.getEmail());
		
		if ( humanResourceUser != null) {
			log.info("Email ile kayıtlı kullanıcı var");
			return;
		}
		
		OperationClaim claim = this.operationClaimService.getClaimByClaimName("ADMIN");
		
		user.setOperationClaim(claim);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.humanResourceUserDao.save(user);
	}

	@Override
	public void delete(int userId) {
		
		log.info("Kullanıcı silindi");
		
		this.humanResourceUserDao.deleteById(userId);
		
	}
	

}
