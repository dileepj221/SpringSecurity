package com.springsecurityexample.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest
{
  @Test
  public void bcryptTest ()
  {
  	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
  	String encodedPassword = encoder.encode("test123");
  	System.out.println(encodedPassword);
  }
}
