package com.tarena.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.entity.Schedule;
import com.tarena.service.ScheduleService;
import com.tarena.utils.TimeUtils;

@Controller
@Scope("prototype")
public class ScheduleAction {
	@Resource
	private ScheduleService scheduleServiceImpl;
	private List<Schedule> scheduleList;
	private Schedule schedule;
	private Integer id;
	private Integer userId;
	private Integer facilityId;
	private String startTime;
	private String endTime;
	private String scheduleName;
	private String scheduleJS;
	private Map<String, String> scheduleMap;
	private Map<String, Object> infoMap;
	private String[] daysStrings;
	private String appointDate;

	// 衍生变量
	private int page = 1;
	private int pageSize;
	private int totalPage;

	public String addScheduleJS() {
		System.out.println("schedule.getFacilityId():" +schedule.getFacilityId());
		System.out.println("schedule.getAppointDate(): " + schedule.getAppointDate());
		System.out.println("schedule.getStartTime(): " + schedule.getStartTime());
		System.out.println("schedule.getUserId(): " + schedule.getUserId());
		
		scheduleServiceImpl.addScheduleJS(schedule);

		scheduleList = scheduleServiceImpl.selectScheduleListByUserId(schedule.getAppointDate() ,schedule.getUserId());
		if (scheduleList.size()!=0) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("scheduleList", scheduleList);
			return "success";
		}
		return "error";
	}

	public String addSchedule() {
		scheduleServiceImpl.addSchedule(schedule);
		return "success";
	}

	public String deleteSchedule() {
		scheduleServiceImpl.deleteSchedule(id);
		return "success";
	}

	public String modifySchedule() {
		scheduleServiceImpl.modifySchedule(schedule);
		return "success";
	}

	public String selectScheduleList() {
		scheduleList = scheduleServiceImpl.selectScheduleList();
		return "success";
	}

	public String selectScheduleById() {
		schedule = scheduleServiceImpl.selectScheduleById(id);
		return "success";
	}
	
	public String selectScheduleListByUserId() {
		scheduleList = scheduleServiceImpl.selectScheduleListByUserId(userId);
		for (Schedule schedule : scheduleList) {
			String[] timeIntervals = schedule.getEndTime().split(",");
			Date date = schedule.getAppointDate();
			String realStartTime = TimeUtils.calculateTheRealTime(date, Integer
					.parseInt(timeIntervals[0]));
			schedule.setStartTime(realStartTime);
			String realEndTime = TimeUtils.calculateTheRealTime(date, Integer
					.parseInt(timeIntervals[timeIntervals.length - 1]) + 1);
			schedule.setEndTime(realEndTime);
			System.out.println(schedule.getEndTime());
		}
		return "success";
	}

	// 根据FacilityId查询scheduleList
	public String selectScheduleListByFacilityId() {
		List<Schedule> tempSchedules = scheduleServiceImpl.selectScheduleListByFacilityId(facilityId);
		scheduleMap = new HashMap<String, String>();
		daysStrings = new String[7];
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(date);
		date = calendar.getTime();
		scheduleMap.put(sdFormat.format(date), ",");
		daysStrings[0] = sdFormat.format(date);
		for (int i = 1; i < 7; i++) {
			calendar.add(calendar.DATE, 1);
			date = calendar.getTime();
			scheduleMap.put(sdFormat.format(date), ",");
			daysStrings[i] = sdFormat.format(date);
		}
		for (Schedule schedule : tempSchedules) {
			String appointDateString = schedule.getAppointDate().toString()
					.substring(0, 10);
			if (scheduleMap.containsKey(appointDateString)) {
				String stringConcat = scheduleMap.get(appointDateString) 
						+ schedule.getStartTime()+ ",";
				scheduleMap.put(appointDateString, stringConcat);
			}
		}
		return "success";
	}

	public String selectScheduleBySchedulename() {
		schedule = scheduleServiceImpl
				.selectScheduleByScheduleName(scheduleName);
		return "success";
	}

	public String selectScheduleListByPage() {
		scheduleList = scheduleServiceImpl.selectScheduleListByPage(page,
				pageSize);
		return "success";
	}

	// setters and getters
	public ScheduleService getScheduleServiceImpl() {
		return scheduleServiceImpl;
	}

	public void setScheduleServiceImpl(ScheduleService scheduleServiceImpl) {
		this.scheduleServiceImpl = scheduleServiceImpl;
	}

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchedulename() {
		return scheduleName;
	}

	public void setSchedulename(String scheduleName) {
		this.scheduleName = scheduleName;
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

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public String getScheduleJS() {
		return scheduleJS;
	}

	public void setScheduleJS(String scheduleJS) {
		this.scheduleJS = scheduleJS;
	}

	public Map<String, Object> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, Object> infoMap) {
		this.infoMap = infoMap;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Map<String, String> getScheduleMap() {
		return scheduleMap;
	}

	public void setScheduleMap(Map<String, String> scheduleMap) {
		this.scheduleMap = scheduleMap;
	}

	public String[] getDaysStrings() {
		return daysStrings;
	}

	public void setDaysStrings(String[] daysStrings) {
		this.daysStrings = daysStrings;
	}

	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
