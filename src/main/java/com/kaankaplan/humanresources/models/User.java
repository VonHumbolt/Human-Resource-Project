package com.kaankaplan.humanresources.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Email
	private String email;
	
	@NotBlank
	@NotEmpty
	private String password;
	
	@NotBlank
	@NotEmpty
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@NotEmpty
	@Column(name = "last_name")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "claim_id")
	private OperationClaim operationClaim;
}
