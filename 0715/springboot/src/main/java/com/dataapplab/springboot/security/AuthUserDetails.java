package com.dataapplab.springboot.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetails implements UserDetails  {
    private Account user;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthUserDetails(Account user, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.user = user;
        this.authorities = authorities;
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
	}

	@Override
	public String getPassword() {
        return this.user.getPassword();
	}

	@Override
	public String getUsername() {
        return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
        return true; //this.user.isEnabled();
	}

}
