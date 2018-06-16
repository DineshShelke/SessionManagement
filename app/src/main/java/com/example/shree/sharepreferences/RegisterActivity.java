package com.example.shree.sharepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnRegister;
    private TextView mTvLogin;
    private EditText mEtEmail,mEtPassword;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        mBtnRegister = (Button)findViewById(R.id.btnRegister);
        mTvLogin = (TextView)findViewById(R.id.tvLogin);
        mEtEmail = (EditText)findViewById(R.id.etEmail);
        mEtPassword = (EditText)findViewById(R.id.etPassword);
        mBtnRegister.setOnClickListener(this);
        mTvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                register();
                 break;

            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;

                default:
        }
    }

    private void register(){
        String email = mEtEmail.getText().toString();
        String pass = mEtPassword.getText().toString();
       if( email.isEmpty() && pass.isEmpty()){
           displayToast("Username/Password field empty");
       }
       else {
           db.addUser(email,pass);
           displayToast("User registerd");
           finish();
       }
    }

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
