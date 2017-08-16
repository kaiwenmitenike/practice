package com.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

/**
 * 角色表
 * 
 * @author Administrator
 *
 */
public class Role {
	private String id;
	private String rolename;
	private List<Permission> permissionList;// 一个角色对应多个权限
	private List<User> userList;// 一个角色对应多个用户

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Transient
	public List<String> getPermissionsName() {
		List<String> list = new ArrayList<String>();
		List<Permission> perlist = getPermissionList();
		for (Permission per : perlist) {
			list.add(per.getPermissionname());
		}
		return list;
	}
}
