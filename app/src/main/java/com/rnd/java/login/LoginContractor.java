package com.rnd.java.login;

import java.util.List;

public interface LoginContractor {


    interface LoginView {
        public void initSetListn();
        public void validation();
        public void errorLogin();
        public void success();
    }

    interface LoginPresenter {
        public void loginData(String name,String pswd);
        public void validUser();
     }


     interface LogiModel{
        public boolean isValidUser(List<User> users );

     }


}
