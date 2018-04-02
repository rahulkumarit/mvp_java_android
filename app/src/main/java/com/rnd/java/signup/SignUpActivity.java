package com.rnd.java.signup;

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

public class SignUpActivity extends AppCompatActivity implements SignUpContractor.SignUpView {

    private EditText edtFullName, edtUser, edtPswd;
    private Button btnSignUP;
    private SignUpContractor.SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpPresenter = new ISignUpPresneter(this, this);

    }

    @Override
    public void initAndListn() {
        edtFullName = findViewById(R.id.edtFullName);
        edtUser = findViewById(R.id.edtUser);
        edtPswd = findViewById(R.id.edtPswd);
        btnSignUP = findViewById(R.id.btnSignUP);

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPresenter.signUpData(edtFullName.getText().toString().trim(), edtUser.getText().toString().trim(), edtPswd.getText().toString().trim());

            }
        });

    }

    @Override
    public void validation() {
        Toast.makeText(this, "Validation Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorLogin() {
        Toast.makeText(this, "Somthing went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        Toast.makeText(this, "Success signup", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MovieListActivity.class));
    }


}
