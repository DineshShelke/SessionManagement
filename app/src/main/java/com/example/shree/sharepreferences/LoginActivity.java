package com.example.shree.sharepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnLogin,mBtnRegister;
    private EditText mEtEmail,mEtPassword;
    private DbHelper db;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        mBtnLogin = (Button)findViewById(R.id.btnLogin);
        mBtnRegister = (Button)findViewById(R.id.btnRegister);
        mEtEmail = (EditText)findViewById(R.id.etEmail);
        mEtPassword = (EditText)findViewById(R.id.etPassword);
        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    public void login(View view) {

    }

    public void register(View view) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnRegister:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;

                default:
        }
    }

    private void login(){
        String email = mEtEmail.getText().toString();
        String pass = mEtPassword.getText().toString();

        if(db.getUser(email,pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "Wrong email/password", Toast.LENGTH_SHORT).show();
        }
    }
}
