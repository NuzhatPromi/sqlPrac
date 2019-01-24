package io.naztech.dao;

import io.naztech.model.User;

public interface UserDAO {
	boolean addUser(User User) ;
	int deleteUser(User User);
	int updateUser(User User);
	User userFindById(int userid);
	boolean checkWildcard(String str);
	boolean checkIn();
	boolean checkBetween();
	
}
