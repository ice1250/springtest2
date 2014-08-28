package com.taehee.springtest.springtest2;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taehee.springtest.model.LoginModel;
import com.taehee.springtest.model.UserModel;
import com.taehee.springtest.mybatis.UserDaoImpl;

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
		//어려움..
		//이제 쉬워져야할텐데...
		//test1
		return userModel;
	}
	
	@RequestMapping(value = "/loginJson", method = RequestMethod.GET)
	public @ResponseBody LoginModel loginJson(@RequestParam Map<String, String> params, ModelMap model) {
		LoginModel loginModel = new LoginModel();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if (userDaoImpl.getLoginResult(params) == 1) {
			loginModel.result = "로그인 성공";
		} else {
			loginModel.result = "로그인 실패";
		}
		return loginModel;
	}
	
}
