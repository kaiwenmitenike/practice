package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.pojo.Paging;

public class Util {
	/**
	 * 将date类型转化为string类型,获取系统当前时间
	 */
	public static String date(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	/**
	 * UUID作为主键
	 * @return
	 */
	public static String uuid(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	/**
	 * 分页
	 * @param count	总共条数
	 * @param pageNum	第几页
	 * @param pageCount	每页的条数
	 * @return
	 */
	public static Paging paging(int count,int pageNum,int pageCount){
		Paging page = new Paging();
		page.setCount(count);
		page.setPage(pageNum);
		page.setPageCount(pageCount);
		return page;
	}
}
