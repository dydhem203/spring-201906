package kr.ro.kitri.hellospring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ro.kitri.hellospring.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsertUser() {
		User user = new User(600, "test", 100);
		User returned = userDao.insertUser(user);
//		Assert.assertTrue(user.getUserid() == returned.getUserid()); // userid와 리턴된 userid가 같으면 통과
		Assert.assertNotNull(returned); // 리턴받은 객체가 null이 아니면 통과
	}
}
