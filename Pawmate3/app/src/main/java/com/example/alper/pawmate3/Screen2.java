package com.example.alper.pawmate3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen2 extends AppCompatActivity {

    public Button findHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);


        findHomeButton = findViewById(R.id.findHomeB);

        findHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fhb = new Intent(Screen2.this,FindHome.class);
                startActivity(fhb);
            }
        });
    }
}
