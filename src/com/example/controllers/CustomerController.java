package com.example.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.Dao.CustomerDao;
import com.example.Dao.MenuDao;
import com.example.bean.ItemBean;
import com.example.bean.OrderBean;
import com.example.form.CustomerForm;
import com.example.form.LoginForm;

@Controller
public class CustomerController {

	 @RequestMapping(value = "customersuccess",method = RequestMethod.GET)
     public ModelAndView getProfile(@ModelAttribute("loginForm") LoginForm loginForm ) throws ClassNotFoundException, SQLException {
                   String userName = loginForm.getUserName();
                   Map<String,Object> model = new HashMap<String,Object>();
                   CustomerDao cdao = new CustomerDao();
                   MenuDao mdao = new MenuDao();
                   mdao.emptyCart();
                   String customerName = cdao.getCustomerName(userName);
                   model.put("userName", userName);
                   model.put("customerName", customerName);         
                   return new ModelAndView("customerhome","model",model);
     }
	 @RequestMapping(value = "customerhome",method = RequestMethod.GET)
     public ModelAndView returunHome(@RequestParam("userName") String userName ) {
                   Map<String,Object> model = new HashMap<String,Object>();
                   CustomerDao cdao = new CustomerDao();
                   String customerName = cdao.getCustomerName(userName);
                   model.put("userName", userName);
                   model.put("customerName", customerName);         
                   return new ModelAndView("customerhome","model",model);
     }
	 @RequestMapping(value = "retreivecustomerprofile",method = RequestMethod.GET)
	 public String retrieveCustomer(@RequestParam("userName") String userName,Map<String,CustomerForm> model, HttpServletRequest request) throws ClassNotFoundException, SQLException {		           
		           CustomerForm customer = new CustomerForm();
		           CustomerDao cdao = new CustomerDao();
		           customer  = cdao.getCustomer(userName);
		           model.put("CustomerForm", customer);
		           return "update_customer";		 	 
	 }
	 @RequestMapping(value = "updatecustomer",method = RequestMethod.POST)
	 public ModelAndView updateCustomer(@ModelAttribute("CustomerForm") CustomerForm customer,BindingResult result) throws ClassNotFoundException, SQLException {
		           Map<String,Object> model = new HashMap<String,Object>();
		           String userName = customer.getUserName();
		           CustomerDao cdao = new CustomerDao();
		           boolean b  = cdao.updateCustomer(customer);
		           if(b){
		        	   model.put("userName", userName);
		           }		                    
                   return new ModelAndView("customerhome","model",model);
	 }
	 @RequestMapping(value = "customerMenu",method = RequestMethod.GET)
     public ModelAndView getMenu(@RequestParam("username") String userName  ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   ArrayList<ItemBean> itemsList = new ArrayList<ItemBean>();
                   MenuDao mdao = new MenuDao();
          		   itemsList = mdao.displayMenu();
          		   OrderBean orderItem = new OrderBean();
        		   orderItem = mdao.displayCart();
        		   model.put("itemlists", itemsList);
                   model.put("userName", userName);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("viewMenu","model",model);
     }
	 @RequestMapping(value = "additemtocart",method = RequestMethod.POST)
     public ModelAndView addItemToCart(@RequestParam("userName") String userName,@RequestParam("itemNumber") String itemno  ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
                   boolean b = mdao.addItemtoCart(itemno);
                   if(b) {
                	   System.out.println("Item added");                  
          		       ArrayList<ItemBean> itemsList = new ArrayList<ItemBean>();
          		       itemsList = mdao.displayMenu();
          		       OrderBean orderItem = new OrderBean();
          		       orderItem = mdao.displayCart();
          		       model.put("itemlists", itemsList);
                       model.put("userName", userName);
                       model.put("orderItem", orderItem);
                   }
                   return new ModelAndView("viewMenu","model",model);
     }
	 @RequestMapping(value = "editCart",method = RequestMethod.GET)
     public ModelAndView editCart(@RequestParam("userName") String userName) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   OrderBean orderItem = new OrderBean();
          		   orderItem = mdao.displayCart();
                   model.put("userName", userName);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("editCart","model",model);
     }
	 @RequestMapping(value = "deleteItemFromCart",method = RequestMethod.POST)
     public ModelAndView deleteItemFromCart(@RequestParam("userName") String userName, @RequestParam("itemName") String itemName ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
                   boolean b = mdao.deleteItemFromCart(itemName);
                   if(b) {
                	   System.out.println("Item deleted from cart");                  
          		       OrderBean orderItem = new OrderBean();
          		       orderItem = mdao.displayCart();
                       model.put("userName", userName);
                       model.put("orderItem", orderItem);
                   }
                   return new ModelAndView("editCart","model",model);
     }
	 @RequestMapping(value = "createOrder",method = RequestMethod.POST,params={"userName"})
     public ModelAndView createOrder(@RequestParam("userName") String userName) throws ClassNotFoundException, SQLException {                   
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
                   OrderBean orderItem = new OrderBean();
          		   orderItem = mdao.displayCart();
                   System.out.println("Username test in customer controller create order: "+userName);
                   boolean b = false;
                   ArrayList<ItemBean> itemsList = new ArrayList<ItemBean>();
                   String orderNo = mdao.createOrder(userName, orderItem);
                   if(!orderNo.equals(null)) {
                	  itemsList = orderItem.getItemList();
                	  for(ItemBean item: itemsList) {
                		    b = mdao.maintainOrderDetails(item, orderNo);
                		    if(b) {
                		    	System.out.println("Order details entered");
                		    }
                	  }
                   }
                   mdao.emptyCart();
                   orderItem = mdao.viewOrder(orderNo);
                   model.put("userName", userName);
                   model.put("orderNo", orderNo);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("orderSuccess","model",model);
     }
	 @RequestMapping(value = "customerOrderHistory",method = RequestMethod.GET)
     public ModelAndView viewOrderHistory(@RequestParam("username") String userName  ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   ArrayList<OrderBean> ordersList = new ArrayList<OrderBean>();
                   MenuDao mdao = new MenuDao();
          		   ordersList = mdao.viewAllOrdersByUserName(userName);
        		   model.put("ordersList", ordersList);
                   model.put("userName", userName);
                   return new ModelAndView("viewOrderHistory","model",model);
     }
	 @RequestMapping(value = "viewCustomerOrder",method = RequestMethod.GET)
     public ModelAndView viewUserOrder(@RequestParam("userName") String userName,@RequestParam("orderNumber") String orderNo ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   OrderBean orderItem = new OrderBean();
          		   orderItem = mdao.viewOrder(orderNo);
                   model.put("userName", userName);
                   model.put("success", false);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("displayCustomerOrder","model",model);
     }
	 @RequestMapping(value = "updateOrderStatus",method = RequestMethod.POST)
	   public ModelAndView updateOrderStatus(@RequestParam("userName") String userName,@RequestParam("orderNumber") String orderNo,
               @RequestParam("status") String status) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   boolean b;
          		   OrderBean orderItem = new OrderBean();
          		   b = mdao.updateOrderStatus(orderNo,status);
          		   if(b) {
          			   System.out.println("Order cancelled");
          		   }
        		   orderItem = mdao.viewOrder(orderNo);
                   model.put("userName", userName);
                   model.put("success", b);
                   model.put("status",status);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("displayCustomerOrder","model",model);
     }
}
