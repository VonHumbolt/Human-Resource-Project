package com.kaankaplan.humanresources.services.interfaces;

import com.kaankaplan.humanresources.models.OperationClaim;

public interface OperationClaimService {
	
	OperationClaim getClaimByClaimName(String claimName);

}
