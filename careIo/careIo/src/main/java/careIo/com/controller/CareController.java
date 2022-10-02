package careIo.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import careIo.com.entity.User;

@RestController
public class CareController {

	@GetMapping( path ="/hello")
	public String firstMethod()
	{
		return "Hello";
	}
	
	
}
