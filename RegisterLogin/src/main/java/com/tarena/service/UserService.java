package com.tarena.service;

import java.util.List;

import com.tarena.entity.User;

public interface UserService {
	// ��ӵķ���
		public abstract void addUser(User user);

		// ɾ���ķ���
		public abstract void deleteUser(Integer id);

		// �޸ĵķ���
		public abstract void modifyUser(User user);

		// ȫ����ѯ�ķ���
		public abstract List<User> selectUserList();

		// �����ݿ���ˮ��Ϊ������ѯ��Ϣ
		public User selectUserById(Integer id);
		
		// �����ݿ�usernameΪ������ѯ��Ϣ
		public User selectUserByUsername(String username);
		
		// ��ҳ��ѯ�ķ���
		public List<User> selectUserListByPage(int page, int pageSize);

		// ��ѯ��ҳ��
		public int findTotalPage(int pageSize);

}
