package com.training.login_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullname,mEmail,mPassword,mNumber;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar mProgressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        mFullname = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mNumber = findViewById(R.id.number);
        mRegisterBtn = findViewById(R.id.register_button);
        mLoginBtn = findViewById(R.id.create_text);
        mProgressBar = findViewById(R.id.prograssBar);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  final String email = mEmail.getText().toString().trim();
                  final String password = mPassword.getText().toString().trim();
                  final String fullname = mFullname.getText().toString();
                  final String number  = mNumber.getText().toString();



                  if (TextUtils.isEmpty(email)){
                      mEmail.setError("Email is required.");
                      return;
                  }
                  if(TextUtils.isEmpty(password)){
                      mPassword.setError("Password is required.");
                      return;
                  }
                  if(password.length() < 6){
                      mPassword.setError("Password must be >= 6 characters.");
                      return;
                  } else {
                      SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                      SharedPreferences .Editor editor = sharedPreferences.edit();
                      editor.putString("name" , fullname);
                      editor.putString("email" , email);
                      editor.putString("password" , password);
                      editor.apply();

                      Toast.makeText(Register.this, "Registration sucessfull", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(getApplicationContext(),Login.class));

                  }
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });

        


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}