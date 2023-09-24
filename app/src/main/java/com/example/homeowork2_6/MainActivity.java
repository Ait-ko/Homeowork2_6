package com.example.homeowork2_6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        welcomeText = findViewById(R.id.welcomeText);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });


        editTextLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonBackground();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonBackground();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void checkLogin() {
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

        if (login.equals("admin") && password.equals("admin")) {
            welcomeText.setVisibility(View.VISIBLE);
            editTextLogin.setVisibility(View.GONE);
            editTextPassword.setVisibility(View.GONE);
            buttonLogin.setVisibility(View.GONE);
            Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateButtonBackground() {
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!login.isEmpty() || !password.isEmpty()) {
            buttonLogin.setBackgroundColor(getResources().getColor(R.color.orange));
        } else {
            buttonLogin.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }
}




