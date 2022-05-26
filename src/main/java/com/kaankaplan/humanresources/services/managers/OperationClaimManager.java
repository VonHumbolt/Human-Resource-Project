package com.kaankaplan.humanresources.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankaplan.humanresources.dao.OperationClaimDao;
import com.kaankaplan.humanresources.models.OperationClaim;
import com.kaankaplan.humanresources.services.interfaces.OperationClaimService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperationClaimManager implements OperationClaimService{

	private OperationClaimDao operationClaimDao;
	
	@Autowired
	public OperationClaimManager(OperationClaimDao operationClaimDao) {
		super();
		this.operationClaimDao = operationClaimDao;
	}

	@Override
	public OperationClaim getClaimByClaimName(String claimName) {
		
		log.info("Claim ismiyle getirildi");
		
		return this.operationClaimDao.getClaimByClaimName(claimName);
	}

	
}
