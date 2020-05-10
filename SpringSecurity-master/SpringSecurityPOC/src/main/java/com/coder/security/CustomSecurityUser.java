package com.coder.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.coder.domain.User;

public class CustomSecurityUser extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3003903600010463726L;

	public CustomSecurityUser() {
	}

	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
