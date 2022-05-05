package spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// CommandLineRunner: システム実行時に処理を走らせることができる
public class SpringAopApplication implements CommandLineRunner{

	@Autowired
	private SampleController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	//run() : CommandLineRunnerの抽象メソッド。システム実行時に実行する処理を記載。
	public void run(String... args) throws Exception {
//		controller.uploadFile();
//		controller.downloadFile();
	}

}
