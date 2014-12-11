package com.example.form;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
        @NotEmpty
        @Size(min = 6, max = 14)
        private String userName;
        @NotEmpty
        @Size(min = 6, max = 14)
        private String password;
        private String role;
        
        public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public void setUserName(String userName) {
                this.userName = userName;
        }
        public String getUserName() {
                return userName;
        }
        public void setPassword(String password) {
                this.password = password;
        }
        public String getPassword() {
                return password;
        }

}
