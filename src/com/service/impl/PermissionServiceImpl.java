package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PermissionMapper;
import com.service.PermissionService;
import com.shiro.Permission;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	@Override
	public List<Permission> findAll(String username) {
		return permissionMapper.findAll(username);
	}

}
