package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
	
	Map<String,User> users = new HashMap<String,User>();
	
	public RegisterController() {
		User u1 = new User("abhi3","abhi3","abhishek@gmail.com");
		User u2 = new User("test","test","test@gmail.com");
		users.put("abhi3", u1);
		users.put("test", u2);
	}
	
	@RequestMapping(value="/users/register",method=RequestMethod.POST)
	@ResponseBody
	public String registerUser(@ModelAttribute("userid")String userid,@ModelAttribute("password")String password,@ModelAttribute("email")String email) {
		User u = new User(userid,password,email);
		users.put(userid, u);
		return "<html><body bgcolor='coral'>Registered Successfully"+"<a href='/index.html'> Home to login </a>"+"</body></html>";
		
	}
	
	@RequestMapping(value="/users/all",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,User> getAllRegisteredUsers(){
		return users;
	}
	
	@RequestMapping(value="/users/{userid}",method=RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("userid")String userid){
		return users.get(userid);
	}
	
	@RequestMapping(value="/users/login",method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("userid")String userid,@ModelAttribute("password")String password,HttpServletRequest request) {
		User uu = users.get(userid);
		request.getSession().setAttribute("user",uu);
		
		if(uu!=null) {
			if(uu.getPassword().equals(password)) {
				return "Trade";
			}
			else {
				return "PasswordError"; //Logical view name
			}
		}
		else {
			return "Sorry";
		}
	}

}
