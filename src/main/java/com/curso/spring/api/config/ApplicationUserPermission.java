package com.curso.spring.api.config;

public enum ApplicationUserPermission {
	CUSTOMER_READ("customer:read"),
	CUSTOMER_WRITE("customer:write"),
	MOVIE_READ("movie:read"),
	MOVIE_WRITE("movie:write");
	
	private final String permission;
	
	ApplicationUserPermission(String permission){
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
}
