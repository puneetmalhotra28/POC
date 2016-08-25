package com.schoeninteriors.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.schoeninteriors.constants.Constants;
import com.schoeninteriors.service.LoginService;
import com.schoeninteriros.model.Users;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping(value = "/welcome", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(@ModelAttribute("user") Users user, Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null) {
			if (((Users) request.getSession().getAttribute("user")).getUserType().equals(Constants.INTERNAL)) {
				return "welcome";
			} else {
				return "home";
			}
		}
		Users dbUser = loginService.loginUser(user);
		if (dbUser != null) {
			request.getSession().setAttribute("user", dbUser);
			if (dbUser.getUserType().equals(Constants.INTERNAL)) {
				return "welcome";
			} else {
				return "home";
			}
		} else {
			model.addAttribute("invalidUser", "Invalid Login Details");
			return "login/login";
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "home";
	}

	@RequestMapping("/forgot")
	public String forgot() {
		return "login/forgot";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/forgotpassword")
	public ModelAndView forgotPassword(String username, Model model) throws MessagingException {
		String url = "";
		ModelAndView modelAndView = null;
		if (username == null || username.equals("")) {
			url = "login/forgot";
			modelAndView = new ModelAndView(url);
			modelAndView.addObject("information", "Username can't be empty.");
			return modelAndView;
		}
		final Users user = loginService.getUser(username);
		if (user == null) {
			url = "login/forgot";
			modelAndView = new ModelAndView(url);
			modelAndView.addObject("information", "Username doesnot exsist");
			return modelAndView;
		} else {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String toAddr = user.getEmail();
					// email subject
					String subject = "Your Password";
					// email body
					String body = "Hey " + user.getName().toUpperCase() + "!" + " \n Your password is : "
							+ user.getPassword();
					smtpMailSender.sendEmail(toAddr, subject, body);
				}
			}).start();
			url = "login/login";
			modelAndView = new ModelAndView(url);
			modelAndView.addObject("information", "Details have been mailed on your email");
			return modelAndView;
		}
	}

	@RequestMapping("/signup")
	public String signup(@ModelAttribute("user") Users user, Model model) {
		return "login/signup";
	}

}
