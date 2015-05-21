package com.tarena.service;

import java.util.List;

import com.tarena.entity.Facility;

public interface FacilityService {
	// 添加的方法
		public abstract void addFacility(Facility facility);

		// 删除的方法
		public abstract void deleteFacility(Integer id);

		// 修改的方法
		public abstract void modifyFacility(Facility facility);

		// 全部查询的方法
		public abstract List<Facility> selectFacilityList();

		// 以数据库流水号为条件查询信息
		public Facility selectFacilityById(Integer id);
		
		// 以数据库facilityname为条件查询信息
		public List<Facility> selectFacilityByFacilityName(String facilityName);
		
		// 按页查询的方法
		public List<Facility> selectFacilityListByPage(int page, int pageSize);

		// 查询总页数
		public int findTotalPage(int pageSize);

}
