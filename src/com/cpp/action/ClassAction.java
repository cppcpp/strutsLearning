package com.cpp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cpp.dao.daoImpl.OperateClassInfoDaoImpl;
import com.cpp.entity.ClassInfo;

public class ClassAction {
	OperateClassInfoDaoImpl opci=new OperateClassInfoDaoImpl();
	List<ClassInfo> lists=new ArrayList<ClassInfo>();
	
	public List<ClassInfo> getLists() {
		return lists;
	}

	public void setLists(List<ClassInfo> lists) {
		this.lists = lists;
	}

	/*json数据格式
	 * {a:1,b:2}：对象
	 * [1,2]:数组
	 * 
	 * JQuery----ajax
	 * $ajax{
	 * 	type:"post",
	 * 	url:"",
	 * 	dataType:"json",
	 * 	success:
	 * }
	 * */
	//新添加内容
	//新添加内容2
	
	
	
	//查询所有的班级信息
	public String checkAll(){
		lists=opci.CheckAllClassInfo();
		
		/*Iterator i=lists.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		
		return "success";
		
	}
}
