package kr.ro.kitri.hellospring.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ro.kitri.hellospring.model.User;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<User> selectAllUsers(){
		List<User> users = sqlSessionTemplate.selectList("kr.ro.kitri.hellospring.dao.UserDao.selectAllUsers");
		return users;
	}

	public User selectUserByKey(Integer userId) {
		User user = sqlSessionTemplate.selectOne("kr.ro.kitri.hellospring.dao.UserDao.selectUserByKey", userId);
		return user;
	}
	
	public List<User> selectUserByUsername(String username) {
		List<User> users = sqlSessionTemplate.selectList("kr.ro.kitri.hellospring.dao.UserDao.selectUserByUsername", username);
		return users;
	}
	
	public User insertUser(User user) {
		int updated = sqlSessionTemplate.update("kr.ro.kitri.hellospring.dao.UserDao.insertUser",user);
		return user;
	}
}
