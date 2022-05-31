package com.ty.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ty.student.dto.Student;
import com.ty.student.util.ConnectionObject;

public class StudentDao {

	Connection connection = null;

	public int[] saveStudent(List<Student> list) {

		connection = ConnectionObject.getConnection();
		String query = "insert into student values(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			for (Student student : list) {
				preparedStatement.setInt(1, student.getId());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setString(3, student.getEmail());
				preparedStatement.setString(4, student.getPassword());

				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public Student getStudentById(int id) {
		connection = ConnectionObject.getConnection();
		String query = "select * from student where id=?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setPassword(resultSet.getString(4));

				return student;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public int deleteStudent(int id) {
		connection = ConnectionObject.getConnection();
		String query = "delete from student where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return id;

	}

	public int updateStudent(String email, int id) {
		connection = ConnectionObject.getConnection();
		String query = "update student set email=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}

}
