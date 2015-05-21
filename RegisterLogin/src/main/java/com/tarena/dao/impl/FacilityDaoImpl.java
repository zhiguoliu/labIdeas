package com.tarena.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.dao.FacilityDao;
import com.tarena.entity.Facility;

@Repository
public class FacilityDaoImpl extends HibernateDaoSupport implements FacilityDao {
	
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}

	public void addFacility(Facility facility) throws DataAccessException {
		if (facility != null) {
			getHibernateTemplate().save(facility);
		}
	}

	public void deleteFacility(Integer id) throws DataAccessException {
		Facility facility = selectFacilityById(id);
		if (facility != null) {
			getHibernateTemplate().delete(facility);
		}
	}

	public void modifyFacility(Facility facility) throws DataAccessException {
		if (facility != null) {
			getHibernateTemplate().update(facility);
		}
	}

	public List<Facility> selectFacilityList() throws DataAccessException {
		String sql = "from Facility";
		return getHibernateTemplate().find(sql);
	}

	public Facility selectFacilityById(Integer id) throws DataAccessException {

		return (Facility) getHibernateTemplate().load(Facility.class, id);
	}

	public List<Facility> selectFacilityByFacilityName(String facilityNames)
			throws DataAccessException {
		//模糊查询会自动在like后添加单引号
		String sqlString = "from Facility where facilityName like ?";
		String[] facilityNameArr = facilityNames.split("\\s+");
		Set<Facility> facilitySet = new HashSet<Facility>();
		List<Facility> facilityList = new ArrayList<Facility>();
		for (String facilityName : facilityNameArr) {
			facilitySet.addAll(getHibernateTemplate().find(sqlString, "%"+facilityName+"%"));
		}
		facilityList.addAll(facilitySet);
		return  facilityList;
		
	}

	public List<Facility> selectFacilityListByPage(final int page, final int pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sqlString = "from Facility";
				Query query = session.createQuery(sqlString);
				query.setFirstResult((page - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	public int findTotalPage(int pageSize) throws DataAccessException {
		String sqlString = "select count(*) from Facility";
		List<Facility> list = getHibernateTemplate().find(sqlString);
		int rows = Integer.valueOf(list.get(0).toString());
		if (rows % pageSize == 0) {
			return rows / pageSize;
		} else {
			return rows / pageSize + 1;
		}
	}

}
