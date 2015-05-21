package com.tarena.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = new Integer(-1);
	private Integer keeperId;
	private String facilityName;
	private String picture;
	private String introduction;

	@OneToMany
	@JoinColumn(name = "facilityId")
	private Set<Schedule> scheduleSet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKeeperId() {
		return keeperId;
	}

	public void setKeeperId(Integer keeperId) {
		this.keeperId = keeperId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Set<Schedule> getScheduleSet() {
		return scheduleSet;
	}

	public void setScheduleSet(Set<Schedule> scheduleSet) {
		this.scheduleSet = scheduleSet;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	

}
