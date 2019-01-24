package io.naztech.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.naztech.model.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBOperation {
	public User addData(User user1) throws SQLException {
		DBConnection conn = DBConnection.getInstance();

		Connection dbConnection = conn.getConnection();

		String insertSQL = "INSERT INTO [dbo].[Employee_Nuzhat]"
				+ "(e_name,e_userId,e_salary,e_country,e_city,e_zipCode) VALUES" + "(?,?,?,?,?,?)";

		PreparedStatement preparedStatement = dbConnection.prepareStatement(insertSQL);

		preparedStatement.setString(1, user1.getName());
		preparedStatement.setInt(2, user1.getUserId());
		preparedStatement.setString(3, user1.getSalary());
		preparedStatement.setString(4, user1.getCountry());
		preparedStatement.setString(5, user1.getCity());
		preparedStatement.setInt(6, user1.getZipCode());
		preparedStatement.execute();

		return user1;
	}

	public int deleteData(User user1) throws SQLException {
		DBConnection conn = DBConnection.getInstance();

		Connection dbConnection = conn.getConnection();

		String query = "delete from [dbo].[Employee_Nuzhat] where e_name = ?";
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
		preparedStatement.setString(1, user1.getName());

		// execute the prepared statement
		return preparedStatement.executeUpdate();

	}

	public int updateData(User user1) throws SQLException {
		DBConnection conn = DBConnection.getInstance();

		Connection dbConnection = conn.getConnection();

		String query = "update [dbo].[Employee_Nuzhat] set e_salary=?, e_country=? where e_name = ?";
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
		preparedStatement.setString(1, user1.getSalary());
		preparedStatement.setString(2, user1.getCountry());
		preparedStatement.setString(3, user1.getName());

		// execute the prepared statement
		return preparedStatement.executeUpdate();
	}

	public User userFindByIdData(int id) throws SQLException {
		DBConnection conn = DBConnection.getInstance();
		Connection dbConnection = conn.getConnection();

		User user1 = new User();

		String query = "select e_name,e_userId,e_salary,e_country,e_city,e_zipCode from [dbo].[Employee_Nuzhat] where e_userId = ?";
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			user1.setName(rs.getString("e_name"));
			user1.setUserId(rs.getInt("e_userId"));
			user1.setSalary(rs.getString("e_salary"));
			user1.setCountry(rs.getString("e_country"));
			user1.setCity(rs.getString("e_city"));
			user1.setZipCode(rs.getInt("e_zipCode"));

		}
		log.info("{}", user1);
		return user1;
	}

	public boolean checkWildcardData(String str) throws SQLException {
		DBConnection conn = DBConnection.getInstance();
		Connection dbConnection = conn.getConnection();

		String query = "select e_name,e_userId,e_salary,e_country,e_city,e_zipCode from [dbo].[Employee_Nuzhat] where e_name like ? ";
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

		preparedStatement.setString(1, str + "%");
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String nString = rs.getString("e_name");
			String country = rs.getString("e_country");
			String salary = rs.getString("e_salary");
			String city = rs.getString("e_city");
			int zip = rs.getInt("e_zipCode");
			if (nString != null && country != null && salary != null && city != null && zip != 0)
				return true;
		}

		return false;
	}
	
//	public boolean checkInData() {
//		DBConnection conn = DBConnection.getInstance();
//		Connection dbConnection = conn.getConnection();
//
//		String query = "select e_name,e_userId,e_salary,e_country,e_city,e_zipCode from [dbo].[Employee_Nuzhat] where e_city in (?";
//				for (int i = 0; i< numberOfParameters; i++)
//				{ 
//				query = query + ",?";
//				} 
//				query = query + ")";
//		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
//
//		preparedStatement.setString(1, str + "%");
//		ResultSet rs = preparedStatement.executeQuery();
//		while (rs.next()) {
//			String nString = rs.getString("e_name");
//			String country = rs.getString("e_country");
//			String salary = rs.getString("e_salary");
//			String city = rs.getString("e_city");
//			int zip = rs.getInt("e_zipCode");
//			if (nString != null && country != null && salary != null && city != null && zip != 0)
//				return true;
//		}
//
//		return false;
//	}
}
