package com.example.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.form.CustomerForm;
import com.example.utility.*;

public class CustomerDao {
    public String getCustomerName(String userName) {
    	ConnectionUtility chd = new ConnectionUtility();
  		Connection con = null;
  		PreparedStatement ps = null;
  		ResultSet rs=null;
  		String customerName = null;
  		try {	    	
	         con = chd.create();	
	    	 ps =con.prepareStatement("select firstname,lastname from customer where username='"+userName+"' ");
	    	 rs=ps.executeQuery();	
	    	 while(rs.next()) {
                    customerName = rs.getString(1).concat(rs.getString(2));
	    	 }
	    } catch(Exception e) {
			 e.printStackTrace();
		} finally {
			 try {
				con.close();   
			 } catch(Exception e) {
				e.printStackTrace();
			 }
		}
		return customerName;	          
	}
    public CustomerForm getCustomer(String userName) {
    	ConnectionUtility chd = new ConnectionUtility();
  		Connection con = null;
  		PreparedStatement ps = null;
  		ResultSet rs=null;
  		CustomerForm customer = new CustomerForm();
  		try {	    	
	         con = chd.create();	
	    	 ps =con.prepareStatement("select * from customer where username='"+userName+"' ");
	    	 rs=ps.executeQuery();	
	    	 while(rs.next()) {
                  customer.setFirstName(rs.getString(1));
                  customer.setLastName(rs.getString(2));
                  customer.setUserName(rs.getString(3));
                  customer.setStreet(rs.getString(4));
                  customer.setCity(rs.getString(5));
                  customer.setPinCode(Integer.valueOf(rs.getInt(6)));
                  customer.setMobileNum(rs.getLong(7));
	    	 }
	    } catch(Exception e) {
			 e.printStackTrace();
		} finally {
			 try {
				con.close();   
			 } catch(Exception e) {
				e.printStackTrace();
			 }
		}
		return customer;        
	}
    public boolean updateCustomer(CustomerForm customer) {
		boolean b=true;
		int result,result_temp;
		ConnectionUtility chd = new ConnectionUtility();
		Connection con = null;
		PreparedStatement ps = null,ps1 = null;
       try {
			con =chd.create();
			String firstName = customer.getFirstName();
			String lastName = customer.getLastName();
			String userName = customer.getUserName();
			String password = customer.getPassword();
			String street = customer.getStreet();
			String city = customer.getCity();
			Integer pinCode = customer.getPinCode();
			Long mobileNum = customer.getMobileNum();
			ps1 = con.prepareStatement("update LoginDetails set password='"+password+"' where username='"+userName+"' ");			
            result_temp = ps1.executeUpdate();
			ps = con.prepareStatement("update customer set firstname='"+firstName+"',lastname='"+lastName+"',street='"+street+"',"
					                                     + "city='"+city+"',pincode="+pinCode+",mobilenum="+mobileNum+" where username='"+userName+"' ");
			result =ps.executeUpdate();
		    if(result>0 && result_temp>0) {
	                b=true;
	        } else {
	            	b=false;								
	        }
		} catch(Exception e) {
		    e.printStackTrace();
	    }
	     finally {
		   try {
			   con.commit();
			   con.close();
	       } catch(Exception e) {
			   e.printStackTrace();
		   }
	     }
		return b;
	}	
 }
