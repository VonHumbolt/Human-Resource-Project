package com.kaankaplan.humanresources.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaankaplan.humanresources.models.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	
	@Query("From Employee e where e.isRest = :true")
	List<Employee> getRestedUsers(Pageable pageable);

	@Query("From Employee e where e.isRest = :false")
	List<Employee> getNotRestedUsers(Pageable pageable);
}
