package com.intern.security.jpaModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.intern.carRental.primary.abstrct.Account;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Setter
@Getter
public class MyUserDetails implements UserDetails {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    private String emailId;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
    

    
    
    public MyUserDetails(Account user) {
        this.emailId = user.getPerson().getEmail();
        this.password=user.getPassword();
        //this.password = passwordEncoder.encode(user.getPassword());
        this.active = user.isAccActive();
        this.authorities = Arrays.stream(user.getSecurityRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }
    
	@Override
	public String getUsername() {
		return emailId;
	}
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
       // return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));

    	return authorities;
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
    	return active;
    }


}