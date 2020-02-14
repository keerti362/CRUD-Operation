package com.example.h2DatabasePOC.CRUDOperation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ExecutionTimeTrackerAdviceTest {

	@Mock
	ProceedingJoinPoint proceedingJoinPoint;
	
	ExecutionTimeTrackerAdvice executionTimeTrackerAdvice = new ExecutionTimeTrackerAdvice();

	@Test
	public void testTrackTime() throws Throwable {
		executionTimeTrackerAdvice.trackTime(proceedingJoinPoint);

	}

}
