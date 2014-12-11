package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.example.Dao.MenuDao;
import com.example.bean.OrderBean;


@Controller
public class EmployeeController {
	 @RequestMapping(value = "employeesuccess",method = RequestMethod.GET)
     public String showForm2() {
                   return "employeehome";
     }
     @RequestMapping(value="orderRetrival",method = RequestMethod.GET)
     public String showForm() {
                   return "orderRetrival";
     } 
     @RequestMapping(value="searchOrder",method = RequestMethod.GET)        
     public ModelAndView searchOrder(@RequestParam("orderNumber") String orderNo) throws ClassNotFoundException, SQLException { 
                   MenuDao mdao = new MenuDao(); 
                   Map<String,Object> model = new HashMap<String,Object>();
                   OrderBean orderItem = new OrderBean();
                   orderItem = mdao.viewOrder(orderNo); 
                   if(orderItem.getOrderNo() == null) {
        	           model.put("success2", false);
        	           return new ModelAndView("orderRetrival","model",model); 
                   }
                   model.put("orderItem",orderItem); 
                   return new ModelAndView("orderDetails","model",model); 
     }
     
     @RequestMapping(value = "viewOrders",method = RequestMethod.GET)   
     public ModelAndView viewAllOrders( ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   ArrayList<OrderBean> ordersList = new ArrayList<OrderBean>();
                   MenuDao mdao = new MenuDao();
                   mdao.emptyCart();
                   ordersList = mdao.viewAllOrders();
                   model.put("ordersList", ordersList);
                   return new ModelAndView("view_orders","model",model); 
     }
     
	 @RequestMapping(value = "viewOrder2",method = RequestMethod.GET)
     public ModelAndView viewUserOrder(@RequestParam("orderNumber") String orderNo ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   OrderBean orderItem = new OrderBean();
          		   orderItem = mdao.viewOrder(orderNo);
          		   model.put("success2", true);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("orderDetails","model",model);
     }
     @RequestMapping(value = "updateOrderStatusemployee",method = RequestMethod.POST)
     public ModelAndView updateOrderStatus(@RequestParam("userName") String userName,@RequestParam("orderNumber") String orderNo,
    		                               @RequestParam("status") String status) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   boolean b;
          		   OrderBean orderItem = new OrderBean();
          		   b = mdao.updateOrderStatus(orderNo,status);
          		   if(b) {
          			   if(status.equalsIgnoreCase("completed")) {
          				 model.put("status", status);
          			   }
          			   else {
          				 model.put("status", status);
          			   }
          		   }
        		   orderItem = mdao.viewOrder(orderNo);
                   model.put("userName", userName);
                   model.put("success", b);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("orderDetails","model",model);
     }
}