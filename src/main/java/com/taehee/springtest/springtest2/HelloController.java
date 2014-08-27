package com.taehee.springtest.springtest2;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taehee.springtest.model.UserModel;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message",
				"Maven Web Project + Spring 3 MVC - welcome()");
		return "index";
	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - "
				+ name);
		return "index";
	}

	/**
	 * 파라미터 테스트 api. name : String 이름
	 * 
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcomeParam", method = RequestMethod.GET)
	public String welcomeParam(@RequestParam Map<String, String> params,
			ModelMap model) {
		if (params.get("name") == null) {
			model.addAttribute("message", "parameter \"name\" is null ");
		} else {
			model.addAttribute(
					"message",
					"Maven Web Project + Spring 3 MVC Param - "
							+ params.get("name"));
		}

		return "index";
	}
	
	/**
	 * json return 테스트 
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcomeJson", method = RequestMethod.GET)
	public @ResponseBody UserModel welcomeJson(@RequestParam Map<String, String> params, ModelMap model) {
		UserModel userModel = new UserModel();
		userModel.name = params.get("name");
		userModel.age = params.get("age");
		return userModel;
	}
}
