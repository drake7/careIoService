package careIo.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import careIo.com.entity.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("filtering")
	public SomeBean filtering() {
		
		return new SomeBean("Value1","value2","value3");
	}
	

}
