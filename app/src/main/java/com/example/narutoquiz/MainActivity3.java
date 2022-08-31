package com.example.narutoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView result2, highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        result2 = findViewById(R.id.result2);
        highscore = findViewById(R.id.highscore);

        Intent intent = getIntent();
        String result = intent.getStringExtra(MainActivity1.EXTRA_NAME);
        result2.setText(result+ "/15");

    }
}