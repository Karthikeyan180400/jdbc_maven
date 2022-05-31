package com.ty.student.controller;

import com.ty.student.dao.StudentDao;

public class StudentUpdateController {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		int res = studentDao.updateStudent("karthi123@mail.com", 1);
		if(res != 0)System.out.println("Updated");
		else System.out.println("Not Updated");
		

	}

}
