package io.naztech.service;

import java.sql.SQLException;

import io.naztech.model.User;
import lombok.extern.slf4j.Slf4j;
import io.naztech.dao.UserDAO;
import io.naztech.dbUtil.DBOperation;

@Slf4j
public class UserDAOImpl implements UserDAO {
	public boolean addUser(User user) {
		DBOperation dbOperations = new DBOperation();

		try {
			dbOperations.addData(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public int deleteUser(User user) {
		DBOperation dbOperations = new DBOperation();
		int del = 0;

		try {
			del = dbOperations.deleteData(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return del;
	}

	public int updateUser(User user) {
		DBOperation dbOperations = new DBOperation();
		int del = 0;

		try {
			del = dbOperations.updateData(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return del;
	}

	public User userFindById(int userid) {
		DBOperation dbOperations = new DBOperation();
		User user = new User();
		try {
			user = dbOperations.userFindByIdData(userid);
			log.info("{}", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkWildcard(String str) {
		DBOperation dbOperations = new DBOperation();

		try {
			return dbOperations.checkWildcardData(str);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkIn(String str1, String str2) {
		DBOperation dbOperations = new DBOperation();

		try {
			return dbOperations.checkInData(str1, str2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkBetween(int id1, int id2) {
		DBOperation dbOperations = new DBOperation();

		try {
			return dbOperations.checkBetweenData(id1, id2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
