package kr.ro.kitri.hellospring.service;

import java.util.List;

import kr.ro.kitri.hellospring.model.User;

public interface UserService {
	public List<User> searchUsers();
	public User searchUserByUserid(Integer userId);
	public List<User> searchUserByUsername(String username);
	public User registUser(User user);
}
