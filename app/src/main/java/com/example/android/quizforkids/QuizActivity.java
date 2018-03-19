package com.example.android.quizforkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<QuestionModel> listQuestions;
    QuestionModel currentQuestion;

    private TextView mQuestionView;
    String editAnswer;

    private RadioButton mChoiceRadio1;
    private RadioButton mChoiceRadio2;
    private RadioButton mChoiceRadio3;

    private CheckBox mChoiceCheckBox1;
    private CheckBox mChoiceCheckBox2;
    private CheckBox mChoiceCheckBox3;

    private EditText mEditTextAnswer;

    private String mAnswer;
    private String[] mAnswers;
    private int mScore = 0;
    int mQuestionNumber = 0;

    RadioGroup mRadioGroup;

    Button btnNextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        listQuestions = Questions.getQuestion();

        // Questions view
        mQuestionView = (TextView) findViewById(R.id.question);

        // View for the radioGroup answers
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

//        mRadioGroup.clearCheck();
        mChoiceRadio1 = (RadioButton) mRadioGroup.findViewById(R.id.choiceRadio1);
        mChoiceRadio2 = (RadioButton) mRadioGroup.findViewById(R.id.choiceRadio2);
        mChoiceRadio3 = (RadioButton) mRadioGroup.findViewById(R.id.choiceRadio3);

        // View for checkBox answers
        mChoiceCheckBox1 = (CheckBox) findViewById(R.id.choiceCheck1);
        mChoiceCheckBox2 = (CheckBox) findViewById(R.id.choiceCheck2);
        mChoiceCheckBox3 = (CheckBox) findViewById(R.id.choiceCheck3);

        // View for editText answer
        mEditTextAnswer = (EditText) findViewById(R.id.editTextAnswer);

        editAnswer = mEditTextAnswer.getText().toString();
        //mEditTextAnswer.setText(editAnswer);

//        if(editAnswer.equals(mAnswer)){
//            calculateScore();
//        }

        // Display first question
        displayQuestion(mQuestionNumber);

        // Display every question after onClick on Next Button and calculate score
        btnNextQuestion = (Button) findViewById(R.id.nextQuestion);
        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore();
                mQuestionNumber++;

                if (mQuestionNumber == listQuestions.size()) {
                    Intent intent = new Intent(QuizActivity.this, FinalScoreActivity.class);
                    intent.putExtra("score", mScore);
                    startActivity(intent);
                    return;
                }

                displayQuestion(mQuestionNumber);

                onClear(mChoiceRadio1);
                onClear(mChoiceRadio2);
                onClear(mChoiceRadio3);

            }
        });

    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        mRadioGroup.clearCheck();
    }

    public void displayQuestion(int index) {
        currentQuestion = listQuestions.get(index);

        mQuestionView.setText(currentQuestion.getQuestion());

        if (currentQuestion.isCheckBox) {

            mChoiceCheckBox1.setVisibility(View.VISIBLE);
            mChoiceCheckBox2.setVisibility(View.VISIBLE);
            mChoiceCheckBox3.setVisibility(View.VISIBLE);
            mRadioGroup.setVisibility(View.GONE);
            mEditTextAnswer.setVisibility(View.GONE);

            mChoiceCheckBox1.setText(currentQuestion.getChoices()[0]);
            mChoiceCheckBox2.setText(currentQuestion.getChoices()[1]);
            mChoiceCheckBox3.setText(currentQuestion.getChoices()[2]);
        }

        if (currentQuestion.isRadioGroup) {

            mRadioGroup.setVisibility(View.VISIBLE);
            mChoiceCheckBox1.setVisibility(View.GONE);
            mChoiceCheckBox2.setVisibility(View.GONE);
            mChoiceCheckBox3.setVisibility(View.GONE);
            mEditTextAnswer.setVisibility(View.GONE);

            mChoiceRadio1.setText(currentQuestion.getChoices()[0]);
            mChoiceRadio2.setText(currentQuestion.getChoices()[1]);
            mChoiceRadio3.setText(currentQuestion.getChoices()[2]);
        }

        if (currentQuestion.isTextEntry) {
            mEditTextAnswer.setVisibility(View.VISIBLE);

            mRadioGroup.setVisibility(View.GONE);
            mChoiceCheckBox1.setVisibility(View.GONE);
            mChoiceCheckBox2.setVisibility(View.GONE);
            mChoiceCheckBox3.setVisibility(View.GONE);
        }
    }

    void calculateScore() {

        if (currentQuestion.isCheckBox) {
            mAnswers = currentQuestion.getAnswers();
            if (mChoiceCheckBox1.isChecked()) {
                String firstCheckBoxString = currentQuestion.getChoices()[0];
                if (Arrays.asList(mAnswers).contains(firstCheckBoxString)) {
                    // right answer
                    mScore = mScore + 1;
                } else {
                    // wrong answer
                    mScore = mScore - 1;
                }
            }

            if (mChoiceCheckBox2.isChecked()) {
                String secondCheckBoxString = currentQuestion.getChoices()[1];
                if (Arrays.asList(mAnswers).contains(secondCheckBoxString)) {
                    // right answer
                    mScore = mScore + 1;
                } else {
                    // wrong answer
                    mScore = mScore - 1;
                }
            }

            if (mChoiceCheckBox3.isChecked()) {
                String thirdCheckBoxString = currentQuestion.getChoices()[2];
                if (Arrays.asList(mAnswers).contains(thirdCheckBoxString)) {
                    // right answer
                    mScore = mScore + 1;
                } else {
                    // wrong answer
                    mScore = mScore - 1;
                }
            }
        } else {
            mAnswer = currentQuestion.getAnswer();
            if(currentQuestion.isRadioGroup) {
                if (mChoiceRadio1.isChecked()) {
                    if (mChoiceRadio1.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    }
                }

                if (mChoiceRadio2.isChecked()) {
                    if (mChoiceRadio2.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                if (mChoiceRadio3.isChecked()) {
                    if (mChoiceRadio3.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            if(currentQuestion.isTextEntry) {
                if (mEditTextAnswer.getText().toString().equals(mAnswer)) {
                    mScore = mScore + 1;
                    Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
