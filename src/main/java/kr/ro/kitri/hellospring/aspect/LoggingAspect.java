package kr.ro.kitri.hellospring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* kr.ro.kitri.hellospring.service.*.*(..))")
	public void logBeforeServiceMethods(JoinPoint joinPoint) {
		String cName = joinPoint.getSignature().getDeclaringTypeName();
		String mName = joinPoint.getSignature().getName();
		log.info(cName + "." + mName + "() 함수에서 로그를 출력. from 로깅 에스팩트");
	}
}
