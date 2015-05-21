package com.tarena.dao;

import java.util.Date;
import java.util.List;

import com.tarena.entity.Schedule;

public interface ScheduleDao {
	// 添加的方法
	public abstract void addSchedule(Schedule schedule);

	// 删除的方法
	public abstract void deleteSchedule(Integer id);

	// 修改的方法
	public abstract void modifySchedule(Schedule schedule);

	// 全部查询的方法
	public abstract List<Schedule> selectScheduleList();

	// 以数据库流水号为条件查询信息
	public Schedule selectScheduleById(Integer id);
	
	// 以数据库schedulename为条件查询信息
	public Schedule selectScheduleByName(String schedulename);
	
	// 按页查询的方法
	public List<Schedule> selectScheduleListByPage(int page, int pageSize);

	// 查询总页数
	public int findTotalPage(int pageSize);

	public abstract List<Schedule> selectScheduleListByFacilityId(Integer facilityId);

	public abstract List<Schedule> selectScheduleListByUserId(Integer userId);

	public abstract List<Schedule> selectScheduleListByUserId(Date appointDate,
			Integer userId);

}
