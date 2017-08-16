package com.mapper;

import org.apache.ibatis.annotations.Param;

import com.shiro.User;

public interface UserMapper {
	public User findByName(@Param("username") String username);
}
