package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shiro.Role;



public interface RoleMapper {
	public List<Role> findAll(@Param("username") String username);
}
