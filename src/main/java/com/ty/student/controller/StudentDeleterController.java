package com.ty.student.controller;

import com.ty.student.dao.StudentDao;

public class StudentDeleterController {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		int res = studentDao.deleteStudent(3);
		
		if(res !=0)System.out.println("Deleted");
		else System.out.println("Id is not found");
	}

}
