package com.tarena.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.ScheduleDao;
import com.tarena.entity.Schedule;
import com.tarena.service.ScheduleService;

//@Transactional 事务注解方式
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Resource
	private ScheduleDao scheduleDaoImpl;

	public void addSchedule(Schedule schedule) {
		scheduleDaoImpl.addSchedule(schedule);
	}

	public void deleteSchedule(Integer id) {
		scheduleDaoImpl.deleteSchedule(id);
	}

	public void modifySchedule(Schedule schedule) {
		scheduleDaoImpl.modifySchedule(schedule);
	}

	public List<Schedule> selectScheduleList() {

		return scheduleDaoImpl.selectScheduleList();
	}

	public Schedule selectScheduleById(Integer id) {

		return scheduleDaoImpl.selectScheduleById(id);
	}

	public Schedule selectScheduleByScheduleName(String scheduleName) {
		scheduleDaoImpl.selectScheduleByName(scheduleName);
		return null;
	}

	public List<Schedule> selectScheduleListByPage(int page, int pageSize) {
		scheduleDaoImpl.selectScheduleListByPage(page, pageSize);
		return null;
	}

	public int findTotalPage(int pageSize) {
		scheduleDaoImpl.findTotalPage(pageSize);
		return 0;
	}

	public ScheduleDao getScheduleDaoImpl() {
		return scheduleDaoImpl;
	}

	public void setScheduleDaoImpl(ScheduleDao scheduleDaoImpl) {
		this.scheduleDaoImpl = scheduleDaoImpl;
	}

	public void addScheduleJS(Schedule schedule)  {
		String[] scheduleStrings = schedule.getStartTime().split(",");
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < scheduleStrings.length; i++) {
			if (i == 0) {
				if (scheduleStrings[0].matches("\\d")) { 
					startIndex = 0;
				}
			}else if (scheduleStrings[i-1].matches("")) {
				if (scheduleStrings[i].matches("\\d+")) {
					startIndex = schedule.getStartTime().indexOf(String.valueOf(i));
				}
			}else if (scheduleStrings[i].matches("")) {
				if (i<10) {
					endIndex = schedule.getStartTime().indexOf(String.valueOf(i-1))+1;
				}else {
					endIndex = schedule.getStartTime().indexOf(String.valueOf(i-1))+2;
				}
				Schedule scheduleTmp = new Schedule();
				scheduleTmp.setStartTime(schedule.getStartTime().substring(startIndex, endIndex));
				scheduleTmp.setEndTime(schedule.getStartTime().substring(startIndex, endIndex));
				scheduleTmp.setFacilityId(schedule.getFacilityId());
				scheduleTmp.setUserId(schedule.getUserId());
				scheduleTmp.setAppointDate(schedule.getAppointDate());
				addSchedule(scheduleTmp);
			}else if (i==scheduleStrings.length-1) {
				endIndex = schedule.getStartTime().length();
				Schedule scheduleTmp = new Schedule();
				scheduleTmp.setStartTime(schedule.getStartTime().substring(startIndex, endIndex));
				scheduleTmp.setEndTime(schedule.getStartTime().substring(startIndex, endIndex));
				scheduleTmp.setFacilityId(schedule.getFacilityId());
				scheduleTmp.setUserId(schedule.getUserId());
				scheduleTmp.setAppointDate(schedule.getAppointDate());
				addSchedule(scheduleTmp);
			}
		}
		
	
	}

	public void addScheduleJS1(String scheduleJS) {
		String[] schedules = scheduleJS.split(",");
		System.out.println(schedules.length);
		Schedule schedule = null;
		for (int i = 0; i < schedules.length; i++) {
			if (i == 0) {
				if (schedules[i].equals("0")) {
					schedule = new Schedule();
					setScheduleStartTime(schedule, i);
				}
			} else if (!schedules[i - 1].equals(String.valueOf(i - 1))) {
				if (schedules[i].equals(String.valueOf(i))) {
					schedule = new Schedule();
					setScheduleStartTime(schedule, i);
				}
			} else if (!schedules[i].equals(String.valueOf(i))) {
				setScheduleEndTime(schedule, i-1);
				schedule.setFacilityId(9);
				schedule.setUserId(2);
				addSchedule(schedule);
				System.out.println(schedule.getStartTime() + " TO "
						+ schedule.getEndTime());
			}else if (i == schedules.length-1) {
				setScheduleEndTime(schedule, schedules.length-1);
				schedule.setFacilityId(9);
				schedule.setUserId(2);
				addSchedule(schedule);
				System.out.println(schedule.getStartTime() + " TO "
						+ schedule.getEndTime());
			}
		}
		
	}

	private void setScheduleStartTime(Schedule schedule, int i) {
		System.out.println("startTime");
		schedule.setStartTime(calculateTheRealTime(i));
	}

	private void setScheduleEndTime(Schedule schedule, int i) {
		System.out.println("endTime");
		schedule.setEndTime(calculateTheRealTime(i+1));
	}

	private String calculateTheRealTime(int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		String dateString = sdf.format(new Date());
		System.out.println(dateString);
		if (i % 2 == 0) {
			if (i / 2 < 10) {
				return dateString + "0" + i / 2 + ":00:00";
			} else {
				return dateString + i / 2 + ":00:00";
			}
		} else {
			if (i / 2 < 10) {
				return dateString + " 0" + i / 2 + ":30:00";
			} else {
				return dateString + i / 2 + ":30:00";
			}
		}
	}

	public List<Schedule> selectScheduleListByFacilityId(Integer facilityId) {
		
		return scheduleDaoImpl.selectScheduleListByFacilityId(facilityId);
	}

	public List<Schedule> selectScheduleListByUserId(Integer userId) {
//		下面的操作是对数据库的操作，使用前一定要考虑好！！！
//		List<Schedule> scheduleList = 
//		for (Schedule schedule : scheduleList) {
//			String[] timeIntervals = schedule.getStartTime().split(",");
//			String realStartTime = calculateTheRealTime(Integer.parseInt(timeIntervals[0]));
//			schedule.setStartTime(realStartTime);
//			String realEndTime = calculateTheRealTime(Integer.parseInt(timeIntervals[timeIntervals.length-1])+1);
//			schedule.setEndTime(realEndTime);
//		}
		return scheduleDaoImpl.selectScheduleListByUserId(userId);
	}

	@Override
	public List<Schedule> selectScheduleListByUserId(Date appointDate,
			Integer userId) {
		// TODO Auto-generated method stub
		return scheduleDaoImpl.selectScheduleListByUserId(appointDate, userId);
	}

}
