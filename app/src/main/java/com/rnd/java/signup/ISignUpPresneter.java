package com.rnd.java.signup;

import android.content.Context;
import android.text.TextUtils;

public class ISignUpPresneter implements SignUpContractor.SignUpPresenter {

    private Context context;
    private SignUpContractor.SignUpView signUpView;

    public ISignUpPresneter(Context context, SignUpContractor.SignUpView signUpView) {
        this.context = context;
        this.signUpView = signUpView;
        signUpView.initAndListn();
    }

    @Override
    public void signUpData(String full_name, String email, String pswd) {
        if (TextUtils.isEmpty(full_name)) {
            signUpView.validation();
        } else if (TextUtils.isEmpty(email)) {
            signUpView.validation();
        } else if (TextUtils.isEmpty(pswd)) {
            signUpView.validation();
         } else {


         }


    }

    @Override
    public void storeInDatabse() {

    }


}
