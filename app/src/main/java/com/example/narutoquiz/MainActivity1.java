package com.example.narutoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    TextView ques, opt;
    EditText Answers;
    Button submit;
    public static final String EXTRA_NAME = "com.example.narutoquiz.EXTRA.name";
    public static final String HIGH_SCORE = "com.example.narutoquiz.HIGH.SCORE";


    private String[] Questions = {"Who tricks Naruto into stealing a scroll in the first episode of the series?",
            "What is the name of Zabuza's sword?",
            "Which team isn't included in the \"Rookie 9\" classification during the Chunin Exams?",
            "Which of Gamabunta's sons does Naruto accidentally summon during his fight against Gaara?",
            "Who are Itachi and Kisame looking for when they first arrive in Konoha together?",
            "Why is Kakashi always late?",
            "Which members of the Sound Village go to Konoha to bring Sasuke to Orochimaru?",
            "Which of the Eight Gates does Rock Lee stop at against Gaara in the Chunin Exams?",
            "How many times does Naruto use the Nine Tails' power in Part 1 of the series?",
            "What is the Eight Tails' real name?",
            "Which one of the five major Hidden Villages is the only one to never produce a member of the Akatsuki?",
            "Which former Kage was also the Jinchuriki of the Three Tails?",
            "The red spiral on the back of Konoha vests symbolizes a friendship with which clan?",
            "Which Tailed Beast did Rin have inside her?",
            "What is the name of Madara Uchiha's grand plan?"};

    private final String[] Options = {"1.  Iruka\n\n2.  Mizuki\n\n3.  Hiruzen\n\n4.  Mitsuki",
            "1.  Haku\n\n" + "2.  Shark Skin/Samehada\n\n" + "3.  Helmsplitter/Kabutowari\n\n" + "4.  Executioner's Blade/Kubikiribocho",
            "1.  Team 7\n\n" + "2.  Team Guy\n\n" + "3.  Team 8\n\n" + "4.  Team 10",
            "1.  Gamakichi\n\n" + "2.  Gamamoro\n\n" + "3.  Gamatatsu\n\n" + "4.  Gamaken",
            "1.  Kakashi\n\n" + "2.  Nobody\n\n" + "3.  Sasuke\n\n" + "4.  Naruto",
            "1.  He gets lost on the path of life\n\n" + "2.  He visits the Hokage daily\n\n" + "3.  He visits the Memorial Stone\n\n" + "4.  He's reading Jiraiya's novels",
            "1.  Jirobo, Kidomaru, Kimimaro, Ukon\n\n" + "2.  Jirobo, Kidomaru, Kabuto, Sakon\n\n" + "3.  Kidomaru, Tayuya, Sakon, Ukon\n\n" + "4.  Jirobo, Kidomaru, Tayuya, Sakon, Ukon",
            "1.  5th Gate: The Gate of Closing\n\n" + "2.  4th Gate: The Gate of Pain\n\n" + "3.  6th Gate: The Gate of Joy\n\n" + "4.  3rd Gate: The Gate of Life",
            "1.  7\n\n" + "2.  4\n\n" + "3.  5\n\n" + "4.  9",
            "1.  Chomei\n\n" + "2.  Saiken\n\n" + "3.  Gyuki\n\n" + "4.  Matatabi",
            "1.  Hidden Sound\n\n" + "2.  Hidden Cloud\n\n" + "3.  Hidden Mist\n\n" + "4.  Hidden Stone",
            "1.  The Fourth Mizukage\n\n" + "2.  The First Raikage\n\n" + "3.  The Fifth Kazekage\n\n" + "4.  The Second Tsuchikage",
            "1.  Senju\n\n" + "2.  Uzumaki\n\n" + "3.  Namikaze\n\n" + "4.  Uchiha",
            "1.  The Three Tails\n\n" + "2.  The Four Tails\n\n" + "3.  The Two Tails\n\n" + "4.  The Six Tails",
            "1.  Project Tsukuyomi\n\n" + "2.  Project Tsukigakure\n\n" + "3.  Project Tsuki no Me\n\n" + "4.  Infinite Tsukuyomi"};

    private final int[] solution = {2, 4, 2, 1, 4, 3, 4, 1, 1, 3, 2, 1, 2, 1, 4};

    private int index = 0;
    private int score = 0;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ques = findViewById(R.id.textView);
        Answers = findViewById(R.id.Answers);
        opt = findViewById(R.id.options);
        ques.setText(Questions[index]);
        opt.setText(Options[index]);

        submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = Answers.getText().toString();

                if (!(answer.equals(""))) {

                    if (index <= Questions.length) {
                        int ans = Integer.parseInt(answer);
                        if (solution[index] == ans) {
                            score++;
                        }
                        index++;
                        if (index <= Questions.length - 1) {
                            opt.setText(Options[index]);
                            ques.setText(Questions[index]);
                            Answers.setText("");
                        } else {

                            Intent intent;
                            if(score >= 7 && score != 15){
                                Toast.makeText(MainActivity1.this, "Restart The App To Play Again.", Toast.LENGTH_LONG).show();
                                intent = new Intent(MainActivity1.this, MainActivity2.class);
                            }
                            else if(score ==15){
                                Toast.makeText(MainActivity1.this, "Genius XDXD", Toast.LENGTH_SHORT).show();
                                intent = new Intent(MainActivity1.this, MainActivity2.class);
                            }
                            else {
                                Toast.makeText(MainActivity1.this, "Re-watch Naruto You Dumb Dumb", Toast.LENGTH_SHORT).show();
                                intent = new Intent(MainActivity1.this,MainActivity3.class);
                            }
                            String result = Integer.toString(score);
                            intent.putExtra(EXTRA_NAME, result);
                            startActivity(intent);


                        }
                    }
                } else {
                    Toast.makeText(MainActivity1.this, "Enter Value", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}