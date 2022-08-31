package com.example.narutoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView result, highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result = findViewById(R.id.result);
        highScore = findViewById(R.id.highScore);

        Intent intent = getIntent();
        String score = intent.getStringExtra(MainActivity1.EXTRA_NAME);
        result.setText(score + "/15");


    }
}