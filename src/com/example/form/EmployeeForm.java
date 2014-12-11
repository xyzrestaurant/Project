package com.example.form;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeForm {
	@NotEmpty
    @Size(min = 1, max = 14)
    private String firstName;
    @NotEmpty
    @Size(min = 1, max = 14)
    private String lastName;
    @NotEmpty
    @Size(min = 6, max = 14)
    private String userName;

    private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
