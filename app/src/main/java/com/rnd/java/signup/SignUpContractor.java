package com.rnd.java.signup;

public interface SignUpContractor {
    interface SignUpView {
        public void initAndListn();

        public void validation();

        public void errorLogin();

        public void success();
    }

    interface SignUpPresenter {
        public void signUpData(String full_name, String email, String pswd);

        public void storeInDatabse();
    }


}
