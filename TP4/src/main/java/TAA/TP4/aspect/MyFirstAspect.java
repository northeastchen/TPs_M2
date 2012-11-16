package TAA.TP4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import TAA.TP4.client.Client;

@Aspect
public class MyFirstAspect {
	@Before("execution(public * *(..))")
	// @AfterReturning("//PointCut expression")
	public void log(JoinPoint pjp) {
		System.out.println("log : classe : "
				+ pjp.getSignature().getDeclaringTypeName() + " | méthode : "
				+ pjp.getSignature().getName());

	}

	@Around("execution(public * TAA.TP4.client.IClient.run())")
	public void authent(ProceedingJoinPoint pjp) throws Exception {
		if (Client.ok != true) {
			try {
				pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new Exception();
		}
	}
}