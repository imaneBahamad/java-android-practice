package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.login_edit_text)
    EditText loginEditText;
    @BindView(R.id.password_edit_text)
    EditText passwordEditText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void login(View view){
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        System.out.println(login + " " + password);
        if(login.equals("imane.bahamad98@gmail.com") && password.equals("Imane123")) {
            Toast.makeText(getApplicationContext(), "Bon couple login, mot de passe", Toast.LENGTH_SHORT).show();
            intent = new Intent().setClass(this,WelcomeActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(),"Login ou mot de passe incorrecte",Toast.LENGTH_LONG).show();
    }
}