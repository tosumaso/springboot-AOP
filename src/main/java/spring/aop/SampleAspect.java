package spring.aop;

import org.aspectj.lang.JoinPoint;
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
public class SampleAspect {
	private Logger logger = LoggerFactory.getLogger(SampleAspect.class);

	@Before("execution(* spring.aop.SampleController.*(..))")
	//JoinPoint : Adviceを注入した対象の情報を所有
	public void doA(JoinPoint jp) {
		logger.info(jp.getSignature().getDeclaringType().getSimpleName() + "クラスの" + jp.getSignature().getName()
				+ "メソッドを開始します");
	}

	@After("execution(* spring.aop.SampleController.*(..))")
	public void doB(JoinPoint jp) { // メソッド名は何でもよい
		logger.info(jp.getSignature().getDeclaringType().getSimpleName() + "クラスの" + jp.getSignature().getName()
				+ "メソッドを終了します");
	}
	
	@Around("execution(* spring.app.*Service.*(..))")
	public void doD(ProceedingJoinPoint pjp) {
		System.out.println("aroundService開始");
		try {
			Object result = pjp.proceed();
			System.out.println(result);
		} catch (Throwable e) {
			logger.info(e.getMessage());
		}
		System.out.println("aroundService終了");
	}

	@Around("bean(*Controller)")
	//ProceedingJoinPoint : Adviceを注入した対象の情報を所有。@Aroundで使う
	public void doC(ProceedingJoinPoint pjp) {
		//ログはtryの前、後に書く
		logger.info("around開始");
		try {
			//pjp.proceed()でメソッドを実行し、メソッドの戻り値を取得できる
			pjp.proceed();
		} catch (Throwable e) {
			logger.info(e.getMessage());
		}
		logger.info("around終了");
	}
//	
//	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//	public void doD(ProceedingJoinPoint pjp) {
//		System.out.println("around開始");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			logger.info(e.getMessage());
//		}
//		System.out.println("around終了");
//	}
//	@Around("@within(org.springframework.stereotype.Controller)")
//	public void doD(ProceedingJoinPoint pjp) {
//		System.out.println("around開始");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			logger.info(e.getMessage());
//		}
//		System.out.println("around終了");
//	}

}
