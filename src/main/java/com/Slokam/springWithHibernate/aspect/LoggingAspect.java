package com.Slokam.springWithHibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private final static Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	@Before("execution (* com.Slokam.springWithHibernate.controler.*.*(..))")
	public void beforeMethod(JoinPoint jp)
	{
	 String methodName=jp.getSignature().getName();
	 String className=jp.getSignature().getClass().toString();
	 LOGGER.info("Entered into method "+methodName+" of the "+className);
	}
	
	@After("execution (* com.Slokam.springWithHibernate.controler.*.*(..))")
	public void afterMethod(JoinPoint jp)
	{
		String methodName=jp.getSignature().getName();
		 String className=jp.getSignature().getClass().toString();
		 LOGGER.info("Exit from method "+methodName+" of the "+className);
	}

}
