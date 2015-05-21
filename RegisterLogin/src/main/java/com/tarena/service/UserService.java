package com.tarena.service;

import java.util.List;

import com.tarena.entity.User;

public interface UserService {
	// 添加的方法
		public abstract void addUser(User user);

		// 删除的方法
		public abstract void deleteUser(Integer id);

		// 修改的方法
		public abstract void modifyUser(User user);

		// 全部查询的方法
		public abstract List<User> selectUserList();

		// 以数据库流水号为条件查询信息
		public User selectUserById(Integer id);
		
		// 以数据库username为条件查询信息
		public User selectUserByUsername(String username);
		
		// 按页查询的方法
		public List<User> selectUserListByPage(int page, int pageSize);

		// 查询总页数
		public int findTotalPage(int pageSize);

}
