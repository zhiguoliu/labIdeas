package com.tarena.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tarena.entity.Facility;
import com.tarena.entity.Schedule;
import com.tarena.entity.User;
import com.tarena.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
	@Resource
	private UserService userServiceImpl;
	private List<User> userList;
	private User user;
	private Set<Facility> facilitySet;
	private Set<Schedule> scheduleSet;

	private String timeInterval;
	private Map<String, Object> infoMap = new HashMap<String, Object>();

	private Integer id;
	private String username;

	// —‹…˙±‰¡ø
	private int page = 1;
	private int pageSize;
	private int totalPage;

	public String timeInterval() {
		System.out.println(timeInterval);
		infoMap.put("username", "zhangsan");
		infoMap.put("password", "123456");
		return "success";
	}

	public String addUser() {
		user.setUsername(user.getUsername().trim());
		user.setPassword(user.getPassword().trim());
		userServiceImpl.addUser(user);
		return "success";
	}

	public String deleteUser() {
		userServiceImpl.deleteUser(id);
		return "success";
	}

	public String modifyUser() {
		userServiceImpl.modifyUser(user);
		return "success";
	}

	public String selectUserList() {
		userList = userServiceImpl.selectUserList();
		facilitySet = userList.get(0).getFacilitySet();
		for (Facility facility : facilitySet) {
			scheduleSet = facility.getScheduleSet();
			System.out.println(scheduleSet.size());
			if (scheduleSet != null) {
				break;
			}
		}
		return "success";
	}

	public String selectUserById() {
		user = userServiceImpl.selectUserById(id);
		facilitySet = user.getFacilitySet();
		System.out.println("facilitySet.size(): "+facilitySet.size());
		return "success";
	}
	
	public String selectUserAndFacilitiesById() {
		user = userServiceImpl.selectUserById(id);
		facilitySet = user.getFacilitySet();
		System.out.println("facilitySet.size(): "+facilitySet.size());
		return "success";
	}

	public String selectUserByUsername() {
	

		System.out.println(this.user.getUsername() + "--" + this.user.getPassword());
		System.out.println(this.user.getUsername() + "--" + this.user.getPassword());
		User user = userServiceImpl.selectUserByUsername(this.user.getUsername().trim());
		System.out.println(user.getUsername() + " : " + user.getPassword());
		if (user.getPassword().equals(this.user.getPassword().trim())) {
			ServletActionContext.getRequest().getSession()
			.setAttribute("admin", user);
			System.out.println("success");
			return "success";
		}
		System.out.println("error");
		return "error"; 
	} 
	 
	public String logout(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("admin");
		if(user.getId().intValue() == id.intValue()){
			ServletActionContext.getRequest().getSession().setAttribute("admin", null);
			return "success";
		}
		return "error";
	}
 
	public String selectUserListByPage() {
		userList = userServiceImpl.selectUserListByPage(page, pageSize);
		return "success";
	}

	// setters and getters
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Facility> getFacilitySet() {
		return facilitySet;
	}

	public void setFacilitySet(Set<Facility> facilitySet) {
		this.facilitySet = facilitySet;
	}

	public Set<Schedule> getScheduleSet() {
		return scheduleSet;
	}

	public void setScheduleSet(Set<Schedule> scheduleSet) {
		this.scheduleSet = scheduleSet;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Map<String, Object> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, Object> infoMap) {
		this.infoMap = infoMap;
	}

}
