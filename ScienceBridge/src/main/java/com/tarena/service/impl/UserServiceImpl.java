package com.tarena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;
import com.tarena.service.UserService;

//@Transactional 事务注解方式
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDaoImpl;
	
	public void addUser(User user) {
		userDaoImpl.addUser(user);
	}

	public void deleteUser(Integer id) {
		userDaoImpl.deleteUser(id);
	}

	public void modifyUser(User user) {
		userDaoImpl.modifyUser(user);
	}

	public List<User> selectUserList() {
		
		return userDaoImpl.selectUserList();
	}

	public User selectUserById(Integer id) {
		
		return userDaoImpl.selectUserById(id);
	}

	public User selectUserByUsername(String username) {
		
		return userDaoImpl.selectUserByUsername(username);
	}

	public List<User> selectUserListByPage(int page, int pageSize) {
		userDaoImpl.selectUserListByPage(page, pageSize);
		return null;
	}

	public int findTotalPage(int pageSize) {
		userDaoImpl.findTotalPage(pageSize);
		return 0;
	}
	
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	

}
