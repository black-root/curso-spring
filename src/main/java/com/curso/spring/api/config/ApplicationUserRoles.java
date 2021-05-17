package com.curso.spring.api.config;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRoles {
	CUSTOMER(Sets.newHashSet()), 
	ADMIN(Sets.newHashSet(
			ApplicationUserPermission.MOVIE_READ,
			ApplicationUserPermission.MOVIE_WRITE,
			ApplicationUserPermission.CUSTOMER_READ,
			ApplicationUserPermission.CUSTOMER_WRITE));

	
	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	
}
