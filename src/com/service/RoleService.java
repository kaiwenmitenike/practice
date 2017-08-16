package com.service;

import java.util.List;

import com.shiro.Role;

public interface RoleService {
	public List<Role> findAll(String username);
}
