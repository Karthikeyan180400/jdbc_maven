package com.ty.student.controller;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.Student;

public class StudentGetController {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudentById(3);
		System.out.println(student);

	}

}
