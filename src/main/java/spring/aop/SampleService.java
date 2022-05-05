package spring.aop;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	public void testSample() {
		System.out.println("SampleService: 処理");
	}
}
