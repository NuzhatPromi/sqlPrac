package io.naztech.dao;

import io.naztech.model.User;

public interface UserDAO {
	boolean addUser(User User) ;
	int deleteUser(User User);
	int updateUser(User User);
	User userFindById(int userid);
	boolean checkWildcard(String str);
	boolean checkIn(String str1, String str2);
	boolean checkBetween(int id1, int id2);
	boolean checkJoin();
	boolean checkInnerJoin();
	boolean checkLeftJoin();
	boolean checkRightJoin();
	boolean checkFullJoin();
	boolean checkSelfJoin();
}
