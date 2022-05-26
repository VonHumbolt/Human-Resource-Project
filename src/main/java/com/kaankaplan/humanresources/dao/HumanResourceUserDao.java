package com.kaankaplan.humanresources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankaplan.humanresources.models.HumanResourceUser;

@Repository
public interface HumanResourceUserDao extends JpaRepository<HumanResourceUser, Integer> {

}
