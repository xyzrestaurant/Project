package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;











import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.example.Dao.LoginDao;
import com.example.form.CustomerForm;
import com.example.form.LoginForm;

@Controller

public class LoginController {
        @RequestMapping(value = "loginform",method = RequestMethod.GET)
        public String showForm(Map<String, LoginForm> model) {
                LoginForm loginForm = new LoginForm();
                model.put("loginForm", loginForm);
                return "loginform";
        }

        @RequestMapping(value = "loginform",method = RequestMethod.POST)
        public String processForm(@Valid LoginForm loginForm, BindingResult result,
                        Map<String, LoginForm> model, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException{

        	LoginDao ldao = new LoginDao();
            String role,pwd;
            String user = "user";
            String employee = "employee";
            String admin = "admin";
            String defpwd = "pwd001";
            if (result.hasErrors()) {
                   return "loginform";
            }
            loginForm = (LoginForm) model.get("loginForm");
            role = ldao.login(loginForm);
            pwd = loginForm.getPassword();
            System.out.println(role); 
            loginForm.setRole(role);
            redirectAttributes.addFlashAttribute("loginForm",loginForm);
            if(admin.equals(role)){
                 return "redirect:adminsuccess"; 
            } else if(employee.equals(role))	 {
            	System.out.println("employee loginsuccess");
            	if(pwd.equalsIgnoreCase(defpwd)) { 
            		return "redirect: changePwd";
            	}
                return "redirect:employeesuccess"; 
            } else if(user.equals(role)){
                return "redirect:customersuccess"; 
            }
            return "loginfailure"; 
        }
        @RequestMapping(value = "showindex",method = RequestMethod.GET)
        public String showIndex() {              
               return "index";
        }
   	    @RequestMapping(value = "signup",method = RequestMethod.GET)
        public String showSignUpForm(Map<String, CustomerForm> model) {
               CustomerForm customerForm = new CustomerForm();
               model.put("customerForm", customerForm);
               return "sign_up_form";
        }
   	   @RequestMapping(value = "addcustomer",method = RequestMethod.POST)
        public String addItem(CustomerForm customerForm,BindingResult result,
               Map<String, CustomerForm> model, RedirectAttributes redirectAttributes) throws ClassNotFoundException, SQLException{
               LoginDao ldao = new LoginDao();
               customerForm = (CustomerForm) model.get("customerForm");
               boolean b = ldao.addCustomer(customerForm);
               if(b) {
        	        System.out.println(b+" in add customer contoller");
               }
            return "redirect: loginform";   
     }
   	@RequestMapping(value = "changePwd",method = RequestMethod.GET)
    public ModelAndView changePassword(@ModelAttribute("loginForm") LoginForm loginForm) throws ClassNotFoundException, SQLException{
   		   Map<String,Object> model = new HashMap<String,Object>();
   		   String userName = loginForm.getUserName();
           model.put("userName", userName);
           return new ModelAndView("changePassword","model",model);
   }
   	@RequestMapping(value = "updatePwd",method = RequestMethod.POST)
    public String updatePassword(@RequestParam("password") String password, @RequestParam("userName") String userName) throws ClassNotFoundException, SQLException{
           LoginForm loginForm = new LoginForm();
   		   LoginDao ldao = new LoginDao();
           loginForm.setUserName(userName);
           loginForm.setPassword(password);
           boolean b = ldao.changePwd(loginForm);
           if(b) {
    	        System.out.println(b+" in add customer contoller");
           }
        return "redirect: employeesuccess";   
   }
}
