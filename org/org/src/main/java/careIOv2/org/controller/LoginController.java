package careIOv2.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/")
	public String welcome()
	{
		return "Hello";
	}
}
