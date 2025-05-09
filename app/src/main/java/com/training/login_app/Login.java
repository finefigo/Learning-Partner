package com.training.login_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    public static final String TAG = "TAG";
EditText mUsername,mPassword;
Button mLoginBtn;
TextView mSignupBtn;
ProgressBar mProgressbar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        mUsername = findViewById(R.id.edt_email);
        mPassword = findViewById(R.id.edt_password);
        mLoginBtn = findViewById(R.id.btn_login);
        mSignupBtn = findViewById(R.id.signup);
        mProgressbar = findViewById(R.id.prograssBar);

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name", "");
        String savedEmail = sharedPreferences.getString("email","");
        String savedPassword = sharedPreferences.getString("password","");



        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));

            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mUsername.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();


                if (TextUtils.isEmpty(username)){
                    mUsername.setError("username is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Password must be >= 6 characters.");
                    return;
                }
                if (username.equals(savedEmail) && password.equals(password)) {
                    Toast.makeText(Login.this, "Login successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),dashboardMainActivity.class));
                }else {
                    Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

                mProgressbar.setVisibility(View.VISIBLE);
            }
        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}