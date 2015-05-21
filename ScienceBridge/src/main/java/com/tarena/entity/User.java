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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = new Integer(-1);
	private String username;
	private String password;
	
	@OneToMany
	@JoinColumn(name = "keeperId", referencedColumnName="id", nullable = true, insertable = false, updatable = false)
	private Set<Facility> facilitySet;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Facility> getFacilitySet() {
		return facilitySet;
	}

	public void setFacilitySet(Set<Facility> facilitySet) {
		this.facilitySet = facilitySet;
	}

}
