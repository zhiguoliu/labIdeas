package com.tarena.service;

import java.util.Date;
import java.util.List;

import com.tarena.entity.Schedule;

public interface ScheduleService {
	// ���ӵķ���
		public abstract void addSchedule(Schedule schedule);

		// ɾ���ķ���
		public abstract void deleteSchedule(Integer id);

		// �޸ĵķ���
		public abstract void modifySchedule(Schedule schedule);

		// ȫ����ѯ�ķ���
		public abstract List<Schedule> selectScheduleList();

		// �����ݿ���ˮ��Ϊ������ѯ��Ϣ
		public Schedule selectScheduleById(Integer id);
		
		// �����ݿ�schedulenameΪ������ѯ��Ϣ
		public Schedule selectScheduleByScheduleName(String scheduleName);
		
		// ��ҳ��ѯ�ķ���
		public List<Schedule> selectScheduleListByPage(int page, int pageSize);

		// ��ѯ��ҳ��
		public int findTotalPage(int pageSize);

		public abstract void addScheduleJS(Schedule schedule);

		public abstract List<Schedule> selectScheduleListByFacilityId(
				Integer facilityId);

		public abstract List<Schedule> selectScheduleListByUserId(Integer userId);

		public abstract List<Schedule> selectScheduleListByUserId(
				Date appointDate, Integer userId);

}