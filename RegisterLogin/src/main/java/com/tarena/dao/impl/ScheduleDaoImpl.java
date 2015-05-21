package com.tarena.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.dao.ScheduleDao;
import com.tarena.entity.Schedule;

@Repository
public class ScheduleDaoImpl extends HibernateDaoSupport implements ScheduleDao {
	
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}

	public void addSchedule(Schedule schedule) throws DataAccessException {
		if (schedule != null) {
			getHibernateTemplate().save(schedule);
		}
	}

	public void deleteSchedule(Integer id) throws DataAccessException {
		Schedule schedule = selectScheduleById(id);
		if (schedule != null) {
			getHibernateTemplate().delete(schedule);
		}
	}

	public void modifySchedule(Schedule schedule) throws DataAccessException {
		if (schedule != null) {
			getHibernateTemplate().update(schedule);
		}
	}

	public List<Schedule> selectScheduleList() throws DataAccessException {
		String sql = "from Schedule";
		return getHibernateTemplate().find(sql);
	}

	public Schedule selectScheduleById(Integer id) throws DataAccessException {

		return (Schedule) getHibernateTemplate().load(Schedule.class, id);
	}

	public Schedule selectScheduleByName(String schedulename)
			throws DataAccessException {
		String sqlString = "from Schedule where schedulename?";
		return null;
	}

	public List<Schedule> selectScheduleListByPage(final int page, final int pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sqlString = "from Schedule";
				Query query = session.createQuery(sqlString);
				query.setFirstResult((page - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	public int findTotalPage(int pageSize) throws DataAccessException {
		String sqlString = "select count(*) from Schedule";
		List<Schedule> list = getHibernateTemplate().find(sqlString);
		int rows = Integer.valueOf(list.get(0).toString());
		if (rows % pageSize == 0) {
			return rows / pageSize;
		} else {
			return rows / pageSize + 1;
		}
	}

	public List<Schedule> selectScheduleListByFacilityId(Integer facilityId) {
		String sqlString = "from Schedule where (to_days(appointDate) - to_days(now())) between 0 and 7 and facilityId=?";
		return getHibernateTemplate().find(sqlString, facilityId);
		
	}

	public List<Schedule> selectScheduleListByUserId(Integer userId) {
		String sqlString = "from Schedule where (to_days(appointDate) - to_days(now())) between 0 and 7 and userId = ? order by appointDate, endTime";
		return getHibernateTemplate().find(sqlString, userId);
	}

	@Override
	public List<Schedule> selectScheduleListByUserId(Date appointDate,
			Integer userId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sqlString = "from Schedule where appointDate = ? and userId = ? order by endTime";
		return getHibernateTemplate().find(sqlString, new Object[]{appointDate, userId});
	}

}
