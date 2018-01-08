package com.tcs.Repo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.Repo.model.UserVO;
import com.tcs.Repo.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public UserVO get(@PathVariable String id) {
		System.out.println("id is"+id);
		
		String userid=id+".com";
		
		return userService.getuserprofile(userid);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public UserVO create(@RequestBody UserVO uservo) {
		
		System.out.println("username is :"+uservo.getUsername());
		
		return userService.createuser(uservo);
	}


}
