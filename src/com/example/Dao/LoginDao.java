package com.example.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.form.CustomerForm;
import com.example.form.LoginForm;
import com.example.utility.*;
public class LoginDao {
		public String login (LoginForm lb) throws SQLException, ClassNotFoundException
			{
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			String role = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			try {				
				con =chd.create();
				String uid = lb.getUserName();
				String pwd = lb.getPassword();
				ps = con.prepareStatement("select role from LoginDetails where username =? and password=? ");
				ps.setString(1,uid);
				ps.setString(2,pwd);
				rs=ps.executeQuery();
				while(rs.next())
				{
					role=rs.getString(1);
		            
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
			return role;
		}
		public boolean addCustomer(CustomerForm customer) {
			boolean b=true;
			int result;
			int result_temp;
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
           try {				
				con =chd.create();
				String firstName = customer.getFirstName();
				String lastName = customer.getLastName();
				String userName = customer.getUserName();
				String password = customer.getPassword();
				String street = customer.getStreet();
				String city = customer.getCity();
				int pinCode = customer.getPinCode();
				Long mobileNum = customer.getMobileNum();
				ps1 = con.prepareStatement("insert into LoginDetails values('"+userName+"','"+password+"','user')");				
                result_temp = ps1.executeUpdate();
				ps = con.prepareStatement("insert into customer values('"+firstName+"','"+lastName+"','"+userName+"','"+street+"','"+city+"',"+pinCode+","+mobileNum+") ");
				result =ps.executeUpdate();
			     if(result>0 && result_temp>0)
		            {
		                b=true;
		            }
		            else 
		            {
		            	b=false;								
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

		public boolean changePwd(LoginForm loginForm) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			int res;
			boolean b = true;
			PreparedStatement ps = null;
			String uid = loginForm.getUserName();
			String pwd = loginForm.getPassword();
			try {
				con = chd.create();
				ps = con.prepareStatement("Update LoginDetails set password='"+pwd+"'where username='"+uid+"' ");
				res = ps.executeUpdate();
				if(res>0) {
					b= true;
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
