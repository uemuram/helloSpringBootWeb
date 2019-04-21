package com.example.demo;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HelloSpringBootWebController {

	// DIされる
	@Autowired
	HelloSpringBootWebService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("inputvalue") String inputvalue, ModelAndView mv) {

		// DIされたサービス呼び出し
		int x = service.doSomeService();

		mv.setViewName("result");
		mv.addObject("message", inputvalue + x);
		return mv;
	}
}