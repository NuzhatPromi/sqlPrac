package io.naztech.sqlPrac;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import io.naztech.dbUtil.DBOperation;
import io.naztech.model.User;
import io.naztech.service.UserDAOImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBOperationTest {

	@Test
	public void insertTest() throws SQLException {
		User user = new User();
		user.setCity("Dhaka");
		user.setCountry("Bangladesh");
		user.setName("Shaila");
		user.setSalary("40000");
		user.setUserId(201514013);
		user.setZipCode(1216);

		DBOperation dbOperation = new DBOperation();
		assertEquals(user, dbOperation.addData(user));

		user.setCity("Mymensingh");
		user.setCountry("Bangladesh");
		user.setName("Toms");
		user.setSalary("40000");
		user.setUserId(201514032);
		user.setZipCode(1215);

		DBOperation dbOperation2 = new DBOperation();
		assertEquals(user, dbOperation2.addData(user));

		user.setCity("Dhaka");
		user.setCountry("Bangladesh");
		user.setName("Pushpo");
		user.setSalary("35000");
		user.setUserId(201514030);
		user.setZipCode(1206);

		DBOperation dbOperation3 = new DBOperation();
		assertEquals(user, dbOperation3.addData(user));

//		UserDAOImpl userDAOimpl = new UserDAOImpl();
//		assertEquals(user, userDAOimpl.addUser(user));

	}

	@Test
	public void deleteTest() throws SQLException {
		User user = new User();

		user.setCity("Patuakhali");
		user.setCountry("Bangladesh");
		user.setName("Keya");
		user.setSalary("40000");
		user.setUserId(201514052);
		user.setZipCode(1203);

		UserDAOImpl userDAOimpl = new UserDAOImpl();
		assertEquals(1, userDAOimpl.deleteUser(user));

	}

	@Test
	public void updateTest() throws SQLException {
		User user = new User();

		user.setCity("Patuakhali");
		user.setCountry("USA");
		user.setName("Keya");
		user.setSalary("45050");
		user.setUserId(201514052);
		user.setZipCode(1203);

		UserDAOImpl userDAOimpl = new UserDAOImpl();
		assertEquals(1, userDAOimpl.updateUser(user));

	}

	@Test
	public void userFindByIdTest() throws SQLException {
		User user = new User();

		user.setCity("Patuakhali");
		user.setCountry("USA");
		user.setName("Keya");
		user.setSalary("45050");
		user.setUserId(201514052);
		user.setZipCode(1203);

		UserDAOImpl userDAOimpl = new UserDAOImpl();
		assertEquals(user, userDAOimpl.userFindById(201514052));
		// log.info("{}", userDAOimpl);

	}

	@Test
	public void checkWildcardTest() {
		UserDAOImpl userDAOimpl = new UserDAOImpl();
		assertTrue(userDAOimpl.checkWildcard("T"));
		assertFalse(userDAOimpl.checkWildcard("R"));
		assertTrue(userDAOimpl.checkWildcard("S"));
		assertTrue(userDAOimpl.checkWildcard("Pro"));
	}

	@Test
	public void checkInTest() {
		UserDAOImpl userDAOimpl = new UserDAOImpl();
		assertTrue(userDAOimpl.checkIn("Dhaka", "Barisal"));
		assertTrue(userDAOimpl.checkIn("Dhaka", "Barishal"));
		assertFalse(userDAOimpl.checkIn("Dhakaa", "Barishal"));
	}

}
