package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sgin_in button
        Button sgin= findViewById(R.id.sign_inbtn);
        sgin.setOnClickListener(new View.OnClickListener() {//main page
            public void onClick(View v) {
                next_page(v);
            }
        });
//reigster button
        Button register= findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_page(v);
            }
        });



    }
    public void next_page(View v) {   //main page
        Intent intent = new Intent(this, main_page.class);
        startActivity(intent);

    }
    public void register_page(View v) {   //main page
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}