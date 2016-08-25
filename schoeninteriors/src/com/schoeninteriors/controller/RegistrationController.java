package com.schoeninteriors.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.schoeninteriors.service.LoginService;
import com.schoeninteriors.service.RegisterService;
import com.schoeninteriros.model.Users;

@Controller
public class RegistrationController {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(@ModelAttribute("user") Users user, Model model, HttpServletRequest request)
			throws ServletException, IOException {
		String url = "login/login";
		ModelAndView modelAndView = null;
		if (user != null) {
			Users dbUser = loginService.getUser(user.getUsername());
			if (dbUser == null) {
				registerService.registerUser(user);
				modelAndView = new ModelAndView(url);
				modelAndView.addObject("information", "Sucessfully created.");
				return modelAndView;
			}
			url = "login/signup";
			modelAndView = new ModelAndView(url);
			modelAndView.addObject("error", "Username already exsist");
			return modelAndView;
		} else {
			url = "login/signup";
			modelAndView = new ModelAndView(url);
			modelAndView.addObject("error", "Something went wrong. Please try again.");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/editProfile", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Users editProfile(HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			Users dbUser = loginService.getUser(user.getUsername());
			return dbUser;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/editProfilePage")
	public String editProfilePage() {
		return "login/editprofile";
	}

	@RequestMapping(value = "/updateProfile", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Users updateProfile(@ModelAttribute("user") Users user, Model model,
			HttpServletRequest request) {
		Users dbUser = loginService.getUser(user.getUsername());
		return dbUser;
	}

}
