package com.example.alper.pawmate2.feature;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signup = findViewById(R.id.signUpp);
        SpannableString signUp = new SpannableString("Sorry I'm new");
        signUp.setSpan(new UnderlineSpan(), 0, signUp.length(), 0);
        signup.setText(signUp);


        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sU = new Intent(getApplicationContext(), SignUp.class);
                startActivity(sU);
            }
        });
    }
}