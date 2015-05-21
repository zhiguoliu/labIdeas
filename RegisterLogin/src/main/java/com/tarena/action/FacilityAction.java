package com.tarena.action;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.entity.Facility;
import com.tarena.entity.Schedule;
import com.tarena.service.FacilityService;
import com.tarena.utils.UploadUtil;

@Controller
@Scope("prototype")
public class FacilityAction {
	@Resource
	private FacilityService facilityServiceImpl;
	private List<Facility> facilityList;
	private Facility facility;
	private Set<Schedule> scheduleSet;
	private Integer id;
	private String facilityNames;
	private File some;
	private String someFileName;

	// —‹…˙±‰¡ø
	private int page = 1;
	private int pageSize;
	private int totalPage;
	
	public String uploadFile(){
		someFileName = UploadUtil.uploadFile(some, someFileName);
		if (!someFileName.equals("error")) {
			return "success";
		}else {
			return "error";
		}
//		return UploadUtil.uploadFile(some);
	}

	public String addFacility() {
		someFileName = UploadUtil.uploadFile(some, someFileName);
		if (!someFileName.equals("error")) {
			facility.setPicture(someFileName);
			facilityServiceImpl.addFacility(facility);
			return "success";
		}else {
			return "error";
		}
	}

	public String deleteFacility() {
		facilityServiceImpl.deleteFacility(id);
		return "success";
	}

	public String modifyFacility() {
		facilityServiceImpl.modifyFacility(facility);
		return "success";
	}

	public String selectFacilityList() {
		facilityList = facilityServiceImpl.selectFacilityList();
		scheduleSet = facilityList.get(0).getScheduleSet();
		return "success";
	}

	public String selectFacilityById() {
		facility = facilityServiceImpl.selectFacilityById(id);
		return "success";
	}

	public String selectFacilityByFacilityName() {
//		System.out.println(facility.getFacilityName());
		System.out.println(facilityNames);
		facilityList = facilityServiceImpl.selectFacilityByFacilityName(facilityNames);
		return "success";
	}

	public String selectFacilityListByPage() {
		facilityList = facilityServiceImpl.selectFacilityListByPage(page,
				pageSize);
		return "success";
	}

	// setters and getters
	public FacilityService getFacilityServiceImpl() {
		return facilityServiceImpl;
	}

	public void setFacilityServiceImpl(FacilityService facilityServiceImpl) {
		this.facilityServiceImpl = facilityServiceImpl;
	}

	public List<Facility> getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(List<Facility> facilityList) {
		this.facilityList = facilityList;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Set<Schedule> getScheduleSet() {
		return scheduleSet;
	}

	public void setScheduleSet(Set<Schedule> scheduleSet) {
		this.scheduleSet = scheduleSet;
	}

	public File getSome() {
		return some;
	}

	public void setSome(File some) {
		this.some = some;
	}

	public String getSomeFileName() {
		return someFileName;
	}

	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}

	public String getFacilityNames() {
		return facilityNames;
	}

	public void setFacilityNames(String facilityNames) {
		this.facilityNames = facilityNames;
	}
	
	

}
