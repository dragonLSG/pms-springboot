package com.dragon.pmsspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GetHtml {

	@RequestMapping("/hello")
 	public String index(){
		return "MyHtml";
	}
	@RequestMapping("/good")
	public String good(){
		return "good";
	}
}
