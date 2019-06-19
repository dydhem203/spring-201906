package kr.ro.kitri.hellospring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ro.kitri.hellospring.dao.UserDao;
import kr.ro.kitri.hellospring.model.User;
import kr.ro.kitri.hellospring.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public List<User> searchUsers(){
		return userDao.selectAllUsers();
	}
	
	public User searchUserByUserid(Integer userId) {
		return userDao.selectUserByKey(userId);
	}
}
