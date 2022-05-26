package com.kaankaplan.humanresources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaankaplan.humanresources.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("From User u where u.email = :email")
	User getUserByEmail(String email);
}
