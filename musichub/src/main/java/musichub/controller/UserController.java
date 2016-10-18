package musichub.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import musichub.model.User;
import musichub.service.UserService;


@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService ps) {
		this.userService = ps;
	}

	@RequestMapping(value = "/user/add",method=RequestMethod.POST)
	public String addUser(Model model,@Valid @ModelAttribute("user") User u, BindingResult result) {

		
		if(result.hasErrors())
			return "Register";
		
		
		userService.addUser(u);
		return "redirect:/";
		}

	}



