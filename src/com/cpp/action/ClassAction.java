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

	/*json���ݸ�ʽ
	 * {a:1,b:2}������
	 * [1,2]:����
	 * 
	 * JQuery----ajax
	 * $ajax{
	 * 	type:"post",
	 * 	url:"",
	 * 	dataType:"json",
	 * 	success:
	 * }
	 * */
	//���������
	//���������2
	
	
	
	//��ѯ���еİ༶��Ϣ
	public String checkAll(){
		lists=opci.CheckAllClassInfo();
		
		/*Iterator i=lists.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		
		return "success";
		
	}
}
