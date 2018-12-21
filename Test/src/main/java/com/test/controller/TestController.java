package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@GetMapping("tologin")
	private String toLogin() {
		return "login";
	}
	
	/**
	 * 登陆成功后跳转到首页
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("login")
	private String login(@RequestParam String username,@RequestParam String password,Model model) {
		String gender;
		if("admin".equals(username)) {
			gender = "男";
		}else {
			gender = "女";
		}
		model.addAttribute("gender", gender);
		model.addAttribute("num",0);
		model.addAttribute("StringParam","");
		return "/index";
	}
	
	/**
	 * 主页显示
	 * @param num
	 * @param model
	 * @return
	 */
	@GetMapping("/index/{num}")
	private String toindex(@PathVariable int num,Model model) {
		List<String> list = new ArrayList<String>();
		list.add("题目1");
		list.add("题目2");
		list.add("题目3");
		list.add("题目4");
		list.add("题目5");
		list.add("题目6");
		list.add("题目7");
		String param = list.get(num);
		num = num+1;
		model.addAttribute("num", num);
		model.addAttribute("StringParam",param);
		return "index :: #chliden";
	}
	
}
