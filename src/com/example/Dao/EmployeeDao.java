package com.example.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.form.EmployeeForm;
import com.example.utility.*;

public class EmployeeDao {
	
	public boolean addEmployee(EmployeeForm employeeForm) throws SQLException, ClassNotFoundException {
		ConnectionUtility chd = new ConnectionUtility();
		Connection con = null;
		int res,result_temp;
		boolean b = true;
		PreparedStatement ps = null,ps1 = null;
		String firstName = employeeForm.getFirstName();
		String lastName = employeeForm.getLastName();
		String userName = employeeForm.getUserName();
		try {
			con = chd.create();
			ps = con.prepareStatement("insert into EmployeeDetails values ('"+firstName+"','"+lastName+"','"+userName+"')");
			res = ps.executeUpdate();
			if(res>0) {
				b= true;
				ps1 = con.prepareStatement("insert into LoginDetails values('"+userName+"','pwd001','employee')");
	            result_temp = ps1.executeUpdate();
	            if(result_temp>0) {
	            	b= true;
	            } else {
	            	b= false;
	            }
			} else {
				b= false;
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try  {
				con.close();   
			 } catch(Exception e) {
				e.printStackTrace();
			 }
		}
		return b;
	}


}
