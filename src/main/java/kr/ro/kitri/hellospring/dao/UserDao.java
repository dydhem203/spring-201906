package kr.ro.kitri.hellospring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ro.kitri.hellospring.model.User;

@Repository
public class UserDao {
	
	public List<User> selectAllUsers() {
		List<User> listOfUser = new ArrayList<User>();
		listOfUser.add(new User(1, "김순곤", 40));
		listOfUser.add(new User(2, "김철수", 50));
		listOfUser.add(new User(3, "홍길동", 20));
		listOfUser.add(new User(4, "신짱구", 5));
		listOfUser.add(new User(5, "신짱아", 2));
		return listOfUser;
	}
	
	public User selectUserByKey(Integer userId) {
		User user = new User(userId, "김순곤", 40);
		return user;
	}
}
