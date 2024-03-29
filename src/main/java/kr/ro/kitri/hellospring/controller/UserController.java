package kr.ro.kitri.hellospring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ro.kitri.hellospring.model.User;
import kr.ro.kitri.hellospring.service.UserService;

@Controller
@ResponseBody
public class UserController{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	

	// http://192.168.0.8:8080/greet
	@GetMapping("/greet")
	@ResponseBody // jsp 파일 없이 화면에 뿌려줌.
	public String hello() {
		return "Hello World";
	}
	
	// 사용자 전체보기
	@GetMapping("/users")
	public List<User> getAllUsers(@RequestParam(value="page", defaultValue = "0") int page){
		System.out.println("page number = "+page);
		return userService.searchUsers();
	}
	
	// 사용자 상세보기
	@GetMapping("/users/{userId}")
	public User getUsersById(@PathVariable Integer userId) {
		System.out.println(userId + "... from path variable");
		return userService.searchUserByUserid(userId);
	}
	
	// 이름으로 사용자 조회
	@GetMapping("/users/username/{username}")
	public List<User> getUsersByUsername(@PathVariable String username) {
		System.out.println(username + "... from path variable");
		return userService.searchUserByUsername(username);
	}
	
	// 사용자 등록
	@PostMapping("/users")
	public User registUser(@RequestBody User user) {
		log.debug("사용자 등록 시작");
		return userService.registUser(user);
	}
	
	// 사용자 수정
	
	// 사용자 삭제
}
