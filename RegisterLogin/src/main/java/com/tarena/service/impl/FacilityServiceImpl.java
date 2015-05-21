package com.tarena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarena.dao.FacilityDao;
import com.tarena.entity.Facility;
import com.tarena.service.FacilityService;

//@Transactional 事务注解方式
@Service
public class FacilityServiceImpl implements FacilityService{
	@Resource
	private FacilityDao facilityDaoImpl;
	
	public Integer addFacility(Facility facility) {
		return facilityDaoImpl.addFacility(facility);
	}

	public void deleteFacility(Integer id) {
		facilityDaoImpl.deleteFacility(id);
	}

	public void modifyFacility(Facility facility) {
		facilityDaoImpl.modifyFacility(facility);
	}

	public List<Facility> selectFacilityList() {
		
		return facilityDaoImpl.selectFacilityList();
	}

	public Facility selectFacilityById(Integer id) {
		
		return facilityDaoImpl.selectFacilityById(id);
	}

	public List<Facility> selectFacilityByFacilityName(String facilityNames) {
		
		return facilityDaoImpl.selectFacilityByFacilityName(facilityNames);
	}

	public List<Facility> selectFacilityListByPage(int page, int pageSize) {
		facilityDaoImpl.selectFacilityListByPage(page, pageSize);
		return null;
	}

	public int findTotalPage(int pageSize) {
		facilityDaoImpl.findTotalPage(pageSize);
		return 0;
	}
	
	public FacilityDao getFacilityDaoImpl() {
		return facilityDaoImpl;
	}
	
	public void setFacilityDaoImpl(FacilityDao facilityDaoImpl) {
		this.facilityDaoImpl = facilityDaoImpl;
	}
	

}
