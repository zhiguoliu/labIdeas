package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;
import com.tarena.service.UserService;

public class TestConnection {
	private String  conf = "applicationContext.xml";
	private ApplicationContext  ac = new ClassPathXmlApplicationContext(conf);
//	@Test
	public void test01(){
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		List<User> users = userDao.selectUserList();
		for (User user : users) {
			System.out.println(user.getId()+ ": "+ user.getUsername()+" : " + user.getPassword());
//			Set<Facility> facilities = user.getFacilities();
//			for (Facility facility : facilities) {
//				System.out.println(facility.getKeeperId());
//			}
		}
	}
	
	@Test
	public void test02(){
			UserService userService = (UserService) ac.getBean("userServiceImpl");
			System.out.println(userService.toString());
			User user = userService.selectUserById(2);
			System.out.println(user.getId()+ ": "+ user.getUsername()+" : " + user.getPassword());
//			Set<Facility> facilities = user.getFacilities();
//			for (Facility facility : facilities) {
//				System.out.println(facility.getId() + " : " + facility.getKeeperId() + " : " + facility.getFacilityName());
//			}
	}

}
