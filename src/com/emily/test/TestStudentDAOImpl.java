package com.emily.test;

import java.util.List;

import org.junit.Test;

import com.emily.entity.Students;
import com.emily.service.impl.StudentsDAOImpl;
import com.emliy.service.StudentsDAO;

public class TestStudentDAOImpl {

	@Test
	public void testQueryAllStudents() {
		StudentsDAO dao = new StudentsDAOImpl();
		List<Students> list = dao.queryAllStudents();
		for(int i=0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testQueryBySid() {
		String sid = "S0000001";
		StudentsDAO dao = new StudentsDAOImpl();
		Students s = dao.queryStudentsBySid(sid);
		System.out.println(s);
	}

}
