package com.rnd.java.login;

import android.content.Context;
import android.text.TextUtils;
import com.rnd.java.db.SqliteHelper;
import java.util.List;

public class ILoginPresenter implements LoginContractor.LoginPresenter {

    private Context contex;
    private LoginContractor.LoginView loginView;

    public ILoginPresenter(Context contex, LoginContractor.LoginView loginView) {
        this.contex = contex;
        this.loginView = loginView;
        loginView.initSetListn();
    }

    @Override
    public void loginData(String name, String pswd) {

        if (TextUtils.isEmpty(name)) {
            loginView.validation();
        } else if (TextUtils.isEmpty(pswd)) {
            loginView.validation();
        } else {
            SqliteHelper sqliteHelper = new SqliteHelper(contex);
            List<User> users = sqliteHelper.getAllUsers();
            LoginContractor.LogiModel logiModel = new User(name, pswd);
            if (logiModel.isValidUser(users)) {
                loginView.success();
            } else {
                loginView.errorLogin();
            }
        }

    }

    @Override
    public void validUser() {


    }


}
