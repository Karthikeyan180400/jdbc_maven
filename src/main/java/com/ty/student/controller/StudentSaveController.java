package com.ty.student.controller;

import java.util.ArrayList;

import com.ty.student.dao.StudentDao;
import com.ty.student.dto.Student;

public class StudentSaveController {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Karthi");
		student1.setEmail("karthi@mail.com");
		student1.setPassword("121212");
		list.add(student1);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Eeshawar");
		student2.setEmail("esh@mail.com");
		student2.setPassword("131313");
		list.add(student2);
		
		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Peter");
		student3.setEmail("peter@mail.com");
		student3.setPassword("141414");
		list.add(student3);
		
		StudentDao studentDao = new StudentDao();
		int[] res = studentDao.saveStudent(list);
		
		if(res != null)System.out.println("Inserted");
		else System.out.println("Not Inserted");
		
		

	}

}
