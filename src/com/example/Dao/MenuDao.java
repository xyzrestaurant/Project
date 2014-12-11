package com.example.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.bean.ItemBean;
import com.example.bean.OrderBean;
import com.example.utility.*;

public class MenuDao {
	
	public ArrayList<ItemBean> displayMenu() throws SQLException, ClassNotFoundException {
		ConnectionUtility chd = new ConnectionUtility();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<ItemBean> itemslist = new ArrayList<ItemBean>();
		try {	    	
	        con = chd.create();	
	    	ps =con.prepareStatement("select * from Items");
	    	rs=ps.executeQuery();	
	    	while(rs.next())  {
	    		ItemBean item = new ItemBean();
                item.setItemNo(rs.getString(1));
                item.setItemName(rs.getString(2));
                item.setDescription(rs.getString(3));
                item.setPrice(rs.getDouble(4));
                item.setStatus(rs.getString(5));
	   	  	    itemslist.add(item);
	   	  	    item = null;
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
		return itemslist;
      
    }
	
	public boolean addItem(ItemBean itemBean) throws SQLException, ClassNotFoundException {
		ConnectionUtility chd = new ConnectionUtility();
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		boolean b = false;
		try {	    	
	         con = chd.create();	
	         st = con.createStatement();
	         String itemName = itemBean.getItemName();
	         String description = itemBean.getDescription();
	         Double price = itemBean.getPrice();
	         rs = st.executeQuery("select itemid_seq.nextval from dual");
	         rs.next();
	         int i = rs.getInt(1);
	         String itemid = "Item"+i;
	    	 ps =con.prepareStatement("insert into Items values('"+itemid+"','"+itemName+"','"+description+"','"+price+"','available') ");
	    	 int result = ps.executeUpdate();
	    	 if(result>0) {
                 b= true;
	    	 }
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try  {
				 con.commit(); 
				 con.close();  
			 } catch(Exception e) {
				e.printStackTrace();
			 }
		}
		return b;          
	} 
	    
	public ItemBean viewItem(String itemno) throws SQLException, ClassNotFoundException {
		ConnectionUtility chd = new ConnectionUtility();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ItemBean item = new ItemBean();
		try {		    	
		     con = chd.create();	
		     ps =con.prepareStatement("select * from Items where itemno = '"+itemno+"' ");
		     rs=ps.executeQuery();	
		     while(rs.next()) {
	              item.setItemNo(rs.getString(1));
	              item.setItemName(rs.getString(2));
	              item.setDescription(rs.getString(3));
	              item.setPrice(rs.getDouble(4));
	              item.setStatus(rs.getString(5));
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
	    return item; 		          
	}
	
	public boolean updateItem(ItemBean itemBean) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			boolean b = false;
			try {
		        con = chd.create();	
		        String itemNo = itemBean.getItemNo();
		        String itemName = itemBean.getItemName();
		        String description = itemBean.getDescription();
		        Double price = itemBean.getPrice();
		    	ps =con.prepareStatement("update items set itemname ='"+itemName+"',description ='"+description+"',price='"+price+"' where itemno = '"+itemNo+"' ");
		    	int result = ps.executeUpdate();
		    	if(result>0) {
	              b= true;
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					con.close();   
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
			return b; 		          
		} 
	
	    public boolean changeItemStatus(String itemNo) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			Statement st = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			boolean b = false;
			String defStatus = "available";
			try  {
		        con = chd.create();	
		        st = con.createStatement();
		        rs = st.executeQuery("select status from Items where itemno = '"+itemNo+"' ");
		        rs.next();
		        String status = rs.getString(1);
                if(defStatus.equals(status)) {
                	status = "unavailable";
                } else {
                	status = defStatus;
                }
		    	ps =con.prepareStatement("update items set status ='"+status+"' where itemno = '"+itemNo+"' ");
		    	int result = ps.executeUpdate();
		    	if(result>0) {
	              b= true;
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();   
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
			return b;      
		} 
	        
	    public boolean deleteItem(String itemNo) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			boolean b = false;
			try {
		        con = chd.create();	
		    	ps =con.prepareStatement("delete from items where itemno = '"+itemNo+"' ");
		    	int result = ps.executeUpdate();
		    	if(result>0) {
	              b= true;
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();  
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
			return b;       
		}
	    
	    public boolean addItemtoCart(String itemno) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			ResultSet rs=null;
	        String itemName = null;
	        Double price = 0.0;
	        boolean b = true;
			try  {
		        con = chd.create();	
		    	ps =con.prepareStatement("select itemname,price from Items where itemno = '"+itemno+"' ");
		    	rs=ps.executeQuery();	
		    	while(rs.next()) {
	                itemName = rs.getString(1);
	                price = rs.getDouble(2);
		    	}
		    	ps1 =con.prepareStatement("insert into cart values('"+itemName+"','"+price+"','1') ");
		    	int result = ps1.executeUpdate();
		    	if(result>0) {
	              b= true;
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();  
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
			return b;		          
		}
	    
	    public OrderBean displayCart() throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			OrderBean orderItem = new OrderBean();
			ArrayList<ItemBean> itemslist = new ArrayList<ItemBean>();
			Double totalAmount = 0.0;
			try {
		        con = chd.create();	
		    	ps =con.prepareStatement("select itemname,sum(price),count(qty) from cart group by itemname");
		    	rs=ps.executeQuery();	
		    	while(rs.next()) {
		    		ItemBean item = new ItemBean();
	                item.setItemName(rs.getString(1));
	                item.setPrice(rs.getDouble(2));
	                item.setQty(rs.getInt(3));
		   	  	    itemslist.add(item);
		   	  	    totalAmount += rs.getDouble(2); 
		   	  	    item = null;
		    	}
		    	orderItem.setItemList(itemslist);
		    	orderItem.setTotalAmount(Math.round(totalAmount*100.0)/100.0);
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
			return orderItem;           
		}
	    
	    public boolean deleteItemFromCart(String itemName) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			boolean b = false;
			try {
		        con = chd.create();	
		    	ps =con.prepareStatement("delete from cart where itemname = '"+itemName+"' ");
		    	int result = ps.executeUpdate();
		    	if(result>0) {
		          b = true;
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();  
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
            return b;
		}
	    
	    public void emptyCart() throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			try {
		        con = chd.create();	
		    	ps =con.prepareStatement("delete from cart");
		    	int result = ps.executeUpdate();
		    	if(result>0) {
		    	}
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();  
				 } catch(Exception e) {
					e.printStackTrace();
				 }
			}
		}
	    
	    public String createOrder(String userName,OrderBean orderItem) throws SQLException, ClassNotFoundException {
	    	ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			Statement st = null;
			ResultSet rs=null;
			String orderNo = null;
			try  {
		        con = chd.create();	
		        st = con.createStatement();
		        rs = st.executeQuery("select orderno_seq.nextval from dual");
		        rs.next();
		        int i = rs.getInt(1);
		        orderNo = "Order"+i;
		        Double totalAmount = orderItem.getTotalAmount();
		    	ps =con.prepareStatement("insert into orderdetails values('"+orderNo+"',sysdate,'"+userName+"',"+totalAmount+",'In Process') ");
		    	int result = ps.executeUpdate();	
		    	if(result > 0) {
                  ps1 = con.prepareStatement("Delete from Cart");
                  int result1 =  ps1.executeUpdate();
                  System.out.println(result1);
                }
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit();  
					 con.close();   
				 } catch(Exception e) {
					 e.printStackTrace();
				 }
			}
			return orderNo;						
	    }
	    
	    public boolean maintainOrderDetails(ItemBean item,String orderNo) throws SQLException, ClassNotFoundException {
	    	ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			boolean b = false;
			try  {	    	
		        con = chd.create();	
                String itemName = item.getItemName();
                Double price = item.getPrice();
	    	    int qty = item.getQty();
	    	    ps =con.prepareStatement("insert into orderlist values('"+itemName+"','"+qty+"','"+price+"','"+orderNo+"') ");
		    	int result = ps.executeUpdate();	
		    	if(result > 0) {
                    b =true;
                }
			} catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				 try  {
					 con.commit(); 
					 con.close();   
				 } catch(Exception e) {
					 e.printStackTrace();
				 }
			}
		    return b;						
	    }
	    
	    public OrderBean viewOrder(String orderNo) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null,ps1 = null;
			ResultSet rs=null,rs1 = null;
			OrderBean orderItem = new OrderBean();
			ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();
			try  {
		        con = chd.create();	
		    	ps =con.prepareStatement("select itemname,qty,price from Orderlist where orderno = '"+orderNo+"' ");
		    	rs=ps.executeQuery();	
		    	while(rs.next())
		    	{
					ItemBean item = new ItemBean();
	                item.setItemName(rs.getString(1));
                    item.setQty(rs.getInt(2));
	                item.setPrice(rs.getDouble(3));
	        	    itemList.add(item);
		   	  	    item = null;
		    	}
		    	orderItem.setItemList(itemList);
		    	ps1 =con.prepareStatement("select * from OrderDetails where orderno = '"+orderNo+"' ");
		    	rs1 =ps1.executeQuery();
		    	while(rs1.next()) {
		    		orderItem.setOrderNo(rs1.getString(1));
		    		orderItem.setOrderdate(rs1.getDate(2));
		    		orderItem.setTotalAmount(rs1.getDouble(4));
		    		orderItem.setStatus(rs1.getString(5));
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
			return orderItem;      
		}
	    
	    public ArrayList<OrderBean> viewAllOrdersByUserName(String userName) throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
			try  {
		        con = chd.create();	
		    	ps =con.prepareStatement("select * from OrderDetails where username = '"+userName+"' ");
		    	rs =ps.executeQuery();
		    	while(rs.next()) {
		    		OrderBean orderItem = new OrderBean();
		    		orderItem.setOrderNo(rs.getString(1));
		    		orderItem.setOrderdate(rs.getDate(2));
		    		orderItem.setTotalAmount(rs.getDouble(4));
		    		orderItem.setStatus(rs.getString(5));
		    		orderList.add(orderItem);
		    		orderItem =null;
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
			return orderList;      
		}
	    
	    public ArrayList<OrderBean> viewAllOrders() throws SQLException, ClassNotFoundException {
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs=null;
			ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
			try  {
		        con = chd.create();	
		    	ps =con.prepareStatement("select * from OrderDetails");
		    	rs =ps.executeQuery();
		    	while(rs.next()) {
		    		OrderBean orderItem = new OrderBean();
		    		orderItem.setOrderNo(rs.getString(1));
		    		orderItem.setOrderdate(rs.getDate(2));
		    		orderItem.setTotalAmount(rs.getDouble(4));
		    		orderItem.setStatus(rs.getString(5));
		    		orderList.add(orderItem);
		    		orderItem =null;
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
			return orderList;      
		}
	    
	    public boolean updateOrderStatus(String orderNo,String status) {
			boolean b=true;
			int result;
			ConnectionUtility chd = new ConnectionUtility();
			Connection con = null;
			PreparedStatement ps = null;
	        try {
				con =chd.create();
				ps = con.prepareStatement("update OrderDetails set Status='"+status+"' where orderno='"+orderNo+"' ");
				result =ps.executeUpdate();
			    if(result>0 ) {
		             b=true;
		        }  else {
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
	}
	

