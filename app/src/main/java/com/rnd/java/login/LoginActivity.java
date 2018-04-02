package com.rnd.java.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rnd.java.R;
import com.rnd.java.list.MovieListActivity;

public class LoginActivity extends AppCompatActivity implements LoginContractor.LoginView {

    private LoginContractor.LoginPresenter loginPresenter;
    private EditText edtUser, edtPswd;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new ILoginPresenter(this, this);
    }


    @Override
    public void initSetListn() {
        edtUser = findViewById(R.id.edtUser);
        edtPswd = findViewById(R.id.edtPswd);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.loginData(edtUser.getText().toString().trim(), edtPswd.getText().toString().trim());
            }
        });

    }

    @Override
    public void validation() {
        Toast.makeText(this, "Vlidation Issues", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorLogin() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MovieListActivity.class));
    }


}
