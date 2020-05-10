package com.coder.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * This class enables method level security. 
 * It allows user to access method based on roles assigned to the user. 
 * Implementation can be see in AdminService class.
 * We can have prepostenabled inside EnableGlobalMethodSecurity to make it more fancy and add few more security. 
 * there's a lot to explore in this configuration class.
 * */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

}
