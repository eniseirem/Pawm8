package com.example.alper.pawmate3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private FirebaseAuth mAuth;
    private static final String TAG = "Login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        inputEmail =  findViewById(R.id.emailInput);
        inputPassword = findViewById(R.id.passwordIn);
        auth = FirebaseAuth.getInstance();

        TextView signup = findViewById(R.id.signUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(), SignUp.class);
                startActivity(int1);
            }
        });

        TextView forgotpw = findViewById(R.id.forgotPw);
        forgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(getApplicationContext(), ForgotPw.class);
                startActivity(int2);
            }
        });

        TextView expl1 = findViewById(R.id.exp1);
        expl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(), Explan1.class);
                startActivity(int3);
            }
        });

        Button loginb = findViewById(R.id.loginB);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent int4 = new Intent(getApplicationContext(), Screen2.class);
                startActivity(int4);*/

                auth.signInWithEmailAndPassword(inputEmail.getText().toString(), inputPassword.getText().toString())
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Login.this, Screen2.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Login.this,"Email or password is wrong",Toast.LENGTH_SHORT).show();
                                }
                        }

                });
            }
        });
    }
}