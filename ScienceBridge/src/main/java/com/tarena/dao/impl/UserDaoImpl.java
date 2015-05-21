package com.tarena.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}

	public void addUser(User user) throws DataAccessException {
		if (user != null) {
			getHibernateTemplate().save(user);
		}
	}

	public void deleteUser(Integer id) throws DataAccessException {
		User user = selectUserById(id);
		if (user != null) {
			getHibernateTemplate().delete(user);
		}
	}

	public void modifyUser(User user) throws DataAccessException {
		if (user != null) {
			getHibernateTemplate().update(user);
		}
	}

	public List<User> selectUserList() throws DataAccessException {
		String sql = "from User";
		return getHibernateTemplate().find(sql);
	}

	public User selectUserById(Integer id) throws DataAccessException {

		return (User) getHibernateTemplate().load(User.class, id);
	}

	public User selectUserByUsername(String username)
			throws DataAccessException {
		String sqlString = "from User where username=?";
		List<User> userList = getHibernateTemplate().find(sqlString, username);
		for (User user : userList) {
			if(user != null){
				return user;
			}
		}
		return null;
		
	}

	public List<User> selectUserListByPage(final int page, final int pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sqlString = "from User";
				Query query = session.createQuery(sqlString);
				query.setFirstResult((page - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	public int findTotalPage(int pageSize) throws DataAccessException {
		String sqlString = "select count(*) from User";
		List<User> list = getHibernateTemplate().find(sqlString);
		int rows = Integer.valueOf(list.get(0).toString());
		if (rows % pageSize == 0) {
			return rows / pageSize;
		} else {
			return rows / pageSize + 1;
		}
	}

}
