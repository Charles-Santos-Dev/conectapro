package com.conectapro.conectapro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    
	/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    
	@Id
	@Column(name = "login", length = 50, nullable = false)
    private String login;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
