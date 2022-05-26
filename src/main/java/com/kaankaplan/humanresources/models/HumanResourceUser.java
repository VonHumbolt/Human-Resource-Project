package com.kaankaplan.humanresources.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class HumanResourceUser extends User{

	@Column(name = "phone_number")
	private int phoneNumber;
	
	@OneToMany(mappedBy = "hemonResourceUser")
	private List<Employee> employees;
}
