package com.example.android.quizforkids;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {

    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        // get the Intent score value from QuizActivity
        int score = getIntent().getIntExtra("score", 0 );

        scoreText= (TextView) findViewById(R.id.scoreText);

        // set score string to the integer type variable
        scoreText.setText(getString(R.string.score, score));
    }
}
