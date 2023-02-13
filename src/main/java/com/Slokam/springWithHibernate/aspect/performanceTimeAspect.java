package com.Slokam.springWithHibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class performanceTimeAspect {
	
	private long startTime;
	private final static Logger LOGGER = LoggerFactory.getLogger(performanceTimeAspect.class);
	
	@Around("execution (* com.Slokam.springWithHibernate.controler.*.*.*(..)))")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
   	 
		 String methodName = pjp.getSignature().getName();
		 String className = pjp.getTarget().getClass().toString();
		 long  startTime = System.currentTimeMillis();
		 Object obj=null;
		 try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 long endTime = System.currentTimeMillis(); 
		 long time = endTime-startTime; LOGGER.info("Time taken to execute the method "+methodName+"of the "+className+"  is "+time);
		 return obj;
   }



}
