package careIOv2.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import careIOv2.org.entity.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("filtering")
	public SomeBean filtering() {
		
		return new SomeBean("Value1","value2","value3");
	}
	

}
