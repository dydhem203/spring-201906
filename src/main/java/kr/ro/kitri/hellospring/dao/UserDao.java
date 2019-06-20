package kr.ro.kitri.hellospring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ro.kitri.hellospring.exception.BizException;
import kr.ro.kitri.hellospring.model.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
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
		String sql = "select * from user where userid = ?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
				}
			}, userId);
			return user;
		} catch (DataAccessException e) {
			throw new BizException("사용자 상세조회 에러", e);
		}
	}
	
	public User insertUser(User user) {
		String sql = "INSERT INTO spring.user(userid, username, age) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserid(), user.getUsername(), user.getAge());
		return user;
	}
}
