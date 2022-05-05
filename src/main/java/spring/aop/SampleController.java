 package spring.aop;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	private final SampleService service;
	
	@Autowired
	public SampleController(SampleService service) {
		this.service = service;
	}
	
	public void uploadFile() {
		System.out.println("ファイルのアップロードに成功しました。");
	}
	public void downloadFile() {
		System.out.println("ファイルのダウンロードに成功しました。");
	}
	@GetMapping("/index")
	public String getIndex() {
		service.testSample();
		return "/index";
	}
}
