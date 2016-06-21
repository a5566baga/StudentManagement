package com.emily.action;

import java.text.SimpleDateFormat;
import java.util.List;

import com.emily.entity.Students;
import com.emily.service.impl.StudentsDAOImpl;
import com.emliy.service.StudentsDAO;

public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查询所有学生
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		if(list != null && list.size() > 0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除学生操作
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//添加学生
	public String add() throws Exception{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(dateFormat.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}
	
	//修改学生资料
	public String modify(){
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存修改后的学生资料
	public String save() throws Exception{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(dateFormat.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
	
}
