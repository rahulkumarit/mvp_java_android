package com.rnd.java.login;

public interface LoginContractor {


    interface LoginView {
        public void validation();
        public void errorLogin();
        public void success();
    }

    interface LoginPresenter {
        public void loginData(String name,String pswd);
        public void storeInDatabse();
     }




}
