package com.service;

import java.util.List;

import com.shiro.Permission;

public interface PermissionService {
	public List<Permission> findAll(String username);
}
