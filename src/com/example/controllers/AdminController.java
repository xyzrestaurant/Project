package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;












import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.Dao.EmployeeDao;
import com.example.Dao.MenuDao;
import com.example.bean.ItemBean;
import com.example.bean.OrderBean;
import com.example.form.EmployeeForm;



@Controller
public class AdminController {
	 @RequestMapping(value = "adminsuccess",method = RequestMethod.GET)
     public String showForm2() {
                   return "adminhome";
     }
	 @RequestMapping(value ="addemployee",method = RequestMethod.GET)
     public String addEmployee(Map<String, EmployeeForm> model) {
                   EmployeeForm employeeForm = new EmployeeForm();
                   model.put("employeeForm", employeeForm);
                   return "employeeform";
     }
     @RequestMapping(value ="displayadditem",method = RequestMethod.GET)
     public String displayaddItem(Map<String, ItemBean> model) {
                   ItemBean itemBean = new ItemBean();
                   model.put("itemBean", itemBean);
                   return "add_item";
     }
	 @RequestMapping(value = "processaddemployee",method = RequestMethod.POST)
     public String processForm2(@Valid EmployeeForm employeeForm, BindingResult result,
    		  Map<String, EmployeeForm> model,RedirectAttributes redirectAttributes) throws ClassNotFoundException,NullPointerException,SQLException{
                   boolean res;
                   EmployeeDao edao = new EmployeeDao();
                   if (result.hasErrors()) {
                       return "employeeform";
                   }
                   employeeForm = (EmployeeForm)model.get("employeeForm");
                   res = edao.addEmployee(employeeForm);
                   model.put("employeeform", employeeForm);
                   if(res) {
            	       return "adminhome";
                   }
                   return "redirect:loginsuccess1";
	 }
	 @RequestMapping(value = "viewMenu",method = RequestMethod.GET)
	 public String displayMenu(Map<String,Object> model) throws ClassNotFoundException, SQLException {
		           MenuDao mdao = new MenuDao();
		           ArrayList<ItemBean> itemsList = new ArrayList<ItemBean>();
		           itemsList = mdao.displayMenu();
		           model.put("itemlists", itemsList);
		           return "admin_menu";		 	 
	 }
	 @RequestMapping(value = "retrieveitem",method = RequestMethod.GET)
	 public String retrieveItem(@RequestParam("itemNumber") String itemnumber,Map<String,ItemBean> model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		          MenuDao mdao = new MenuDao();
		          ItemBean itemBean = new ItemBean();
		          itemBean = mdao.viewItem(itemnumber);
		          model.put("itemBean", itemBean);
		          return "update_item";		 	 
	 }
	 @RequestMapping(value = "addItem",method = RequestMethod.POST)
     public String addItem(ItemBean itemBean,BindingResult result,
                     Map<String, ItemBean> model, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException{
                   MenuDao mdao = new MenuDao();
                   itemBean = (ItemBean) model.get("itemBean");
                   boolean b = mdao.addItem(itemBean);
                   if(b) {
                	   return "redirect: viewMenu";
                   } 
                   return "redirect: viewMenu"; 
     }
	 @RequestMapping(value = "updateItem",method = RequestMethod.POST)
     public String updateItem(ItemBean itemBean,BindingResult result,
                     Map<String, ItemBean> model, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException{
                   MenuDao mdao = new MenuDao();
                   itemBean = (ItemBean) model.get("itemBean");
                   boolean b = mdao.updateItem(itemBean);
                   if(b) {
                	   return "redirect: viewMenu";
                   }
                   return "redirect: viewMenu"; 
     }
	 @RequestMapping(value = "statuschange",method = RequestMethod.POST,params={"itemNumber"})
	 public String changeItemStatus(@RequestParam("itemNumber") String itemnumber,Map<String,Object> model, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException {
		           MenuDao mdao = new MenuDao();
		           boolean b = mdao.changeItemStatus(itemnumber);
		           if(b) {
		        	  return "redirect: viewMenu";
	               }
		           return "redirect: viewMenu";	 	 
	 }
	 @RequestMapping(value = "deleteitem",method = RequestMethod.POST,params={"itemNumber"})
	 public String deleteItem(@RequestParam("itemNumber") String itemnumber,Map<String,Object> model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		           MenuDao mdao = new MenuDao();
		           boolean b = mdao.deleteItem(itemnumber);
		           if(b) {
		        	   return "redirect: viewMenu";
                   }
	               return "redirect: viewMenu";
	 }
	 @RequestMapping(value = "viewAllOrders",method = RequestMethod.GET)
     public ModelAndView viewAllOrders( ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   ArrayList<OrderBean> ordersList = new ArrayList<OrderBean>();
                   MenuDao mdao = new MenuDao();
                   mdao.emptyCart();
          		   ordersList = mdao.viewAllOrders();
        		   model.put("ordersList", ordersList);
                   return new ModelAndView("view_all_orders","model",model);
     }
	 @RequestMapping(value = "viewOrder",method = RequestMethod.GET)
     public ModelAndView viewUserOrder(@RequestParam("orderNumber") String orderNo ) throws ClassNotFoundException, SQLException {
                   Map<String,Object> model = new HashMap<String,Object>();
                   MenuDao mdao = new MenuDao();
          		   OrderBean orderItem = new OrderBean();
          		   orderItem = mdao.viewOrder(orderNo);
                   model.put("orderItem", orderItem);
                   return new ModelAndView("viewOrder","model",model);
     }
	 @RequestMapping(value = "updateOrderStatusadmin",method = RequestMethod.POST)
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
                   return new ModelAndView("viewOrder","model",model);
     }	 
}
