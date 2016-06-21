package com.emliy.service;

import java.util.List;

import com.emily.entity.Students;

public interface StudentsDAO {

	//查询所有学生信息
	public List<Students> queryAllStudents();
	//查找某个人的单个信息
	public Students queryStudentsBySid(String sid);
	//增加学生信息
	public boolean addStudents(Students s);
	//修改学生信息
	public boolean updateStudents(Students s);
	//删除学生信息
	public boolean deleteStudents(String sid);
	
}
