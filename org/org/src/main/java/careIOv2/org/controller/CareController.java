package careIOv2.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import careIOv2.org.entity.User;

@RestController
public class CareController {

	@GetMapping( path ="/hello")
	public String firstMethod()
	{
		return "Hello";
	}
	
	
}
