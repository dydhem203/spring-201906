package kr.ro.kitri.hellospring.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value=BizException.class)
	public Map<String, Object> handleBizException(BizException e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", true);
		map.put("msg", e.getMessage());
		map.put("error_code", 120);
		return map;
	}
	
	@ExceptionHandler(value=SQLException.class)
	public Map<String, Object> handleSQLException(SQLException e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", true);
		map.put("msg", e.getMessage());
		map.put("error_code", 120);
		return map;
	}
	
	/*
	 * {
	 * 		"error" : true,
	 * 		"msg" : "You have an error in your SQL syntax",
	 * 		"error_code" : 120
	 * }
	 * */
	
	@ExceptionHandler(value=NumberFormatException.class)
	public String handleNumberFormatException(NumberFormatException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handelException(Exception e) {
		return e.getMessage();
	}
}
