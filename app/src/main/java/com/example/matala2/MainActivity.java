package com.example.matala2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private Button option1, option2, option3, option4 ;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.question_text);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        questions = TheQuizQuestions.getQuestions();

        loadQuestion();

        View.OnClickListener optionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button selectedButton = (Button) view;
                checkAnswer(selectedButton.getText().toString());
                moveToNextQuestion();
            }
        };

        option1.setOnClickListener(optionClickListener);
        option2.setOnClickListener(optionClickListener);
        option3.setOnClickListener(optionClickListener);
        option4.setOnClickListener(optionClickListener);


    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getQuestionText());
            option1.setText(currentQuestion.getOptions().get(0));
            option2.setText(currentQuestion.getOptions().get(1));
            option3.setText(currentQuestion.getOptions().get(2));
            option4.setText(currentQuestion.getOptions().get(3));

        }
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
           // Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
          //  Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            loadQuestion();
        } else {
            Intent intent = new Intent(MainActivity.this, QuizResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("total_questions", questions.size());
            startActivity(intent);
            finish();
        }
    }


}
