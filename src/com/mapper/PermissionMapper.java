package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shiro.Permission;

public interface PermissionMapper {
	public List<Permission> findAll(@Param("username")String username);
}
