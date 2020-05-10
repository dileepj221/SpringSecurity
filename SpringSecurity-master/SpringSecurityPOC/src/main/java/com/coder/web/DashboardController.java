package com.coder.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coder.domain.User;
import com.coder.service.AdminService;

@Controller
public class DashboardController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap map) {
		
		map.put("user", user);
		
		/*
		 * This code is secured with some role and will be only accessible for those
		 * roles only and not for others.
		 * Can be seen in the logs for the successful find all user details.
		 */
		List<User> allUserAccounts = adminService.getAllUserAccounts();
		return "dashboard";
	}

}
