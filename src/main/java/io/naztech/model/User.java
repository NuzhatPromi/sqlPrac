package io.naztech.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
	String Name;
	int UserId;
	String Salary;
	String Country;
	String City;
	int ZipCode;
}
