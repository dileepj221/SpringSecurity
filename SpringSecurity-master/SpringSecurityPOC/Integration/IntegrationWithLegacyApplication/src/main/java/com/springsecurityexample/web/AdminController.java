package com.springsecurityexample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springsecurityexample.service.AdminService;

@Controller
public class AdminController
{
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="admin", method=RequestMethod.GET)
  public String adminPage (ModelMap model)
  {
  	return "admin";
  }
	
	@RequestMapping(value="adminService", method=RequestMethod.GET)
  public String adminService (ModelMap model)
  {
		adminService.performSomeAdminService();
  	return "admin";
  }
	
	@RequestMapping(value="admin/service", method=RequestMethod.GET)
  public String adminSubService (ModelMap model)
  {
		adminService.performSomeAdminService();
  	return "admin";
  }
}
