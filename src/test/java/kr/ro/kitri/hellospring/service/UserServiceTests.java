package kr.ro.kitri.hellospring.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ro.kitri.hellospring.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserService userService;

	@Ignore	// test 무시
	@Test
	public void testRegistUser() {
		User user = new User(602, "test", 100);
		User returned = userService.registUser(user);
		Assert.assertTrue(user.getUserid() == returned.getUserid()); // userid와 리턴된 userid가 같으면 통과
	}
	
	@Test
	public void testSearchUserByUserid() {
		int userId = 500;
		User returned = userService.searchUserByUserid(userId);
		Assert.assertTrue(userId == returned.getUserid());// userid와 리턴된 userid가 같으면 통과
	}
}
