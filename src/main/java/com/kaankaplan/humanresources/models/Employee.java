package com.kaankaplan.humanresources.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee extends User{

	private double salary;
	
	@Column(name = "is_rest")
	private boolean isRest = false;
	
	@Column(name = "expreience_year")
	private int experienceYear;
	
	@Column(name = "militay_case")
	private boolean isMilitayMissionDone;
	
	@Column(name = "rest_day")
	private Date restDay;
	
	@Column(name = "start_year")
	private int startYear;
	
	@Column(name = "finish_year")
	private int finishYear;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private HumanResourceUser hemonResourceUser;
}
