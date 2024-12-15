package com.example.matala2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResultActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "QuizPrefs";
    private static final String KEY_BEST_SCORE = "BestScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_results);

        TextView resultText = findViewById(R.id.result_text); // TextView for displaying the result
        Button restartButton = findViewById(R.id.restart_button); // Restart button

        // Get the score and total questions from the intent passed from MainActivity
        Intent intent = getIntent();
        int currentScore = intent.getIntExtra("score", 0);  // Current user's score
        int totalQuestions = intent.getIntExtra("total_questions", 6);  // Total number of questions (default is 6)

        // Access SharedPreferences to retrieve and update the best score
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int bestScore = preferences.getInt(KEY_BEST_SCORE, 0);  // Default best score is 0

        // Update best score if current score is higher
        if (currentScore > bestScore) {
            bestScore = currentScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(KEY_BEST_SCORE, bestScore);
            editor.apply();  // Save the updated best score
        }

        // Create the result message
        String resultMessage;
        if (currentScore == totalQuestions) {
            // User answered all questions correctly
            resultMessage = "You answered " + currentScore + " out of " + totalQuestions + " questions correctly! Congrats!";
        } else {
            // User did not answer all questions correctly
            resultMessage = "You answered " + currentScore + " out of " + totalQuestions + " questions correctly.\n"
                    + "You can beat this score! It's not your best attempt yet.";
        }

        // Add best score information to the result message
        resultMessage += "\n\nYour best attempt: " + bestScore + " out of " + totalQuestions + " questions.";

        // Display the result message on the TextView
        resultText.setText(resultMessage);

        // Set up the restart button to start a new quiz
        restartButton.setOnClickListener(v -> {
            Intent restartIntent = new Intent(QuizResultActivity.this, MainActivity.class);
            startActivity(restartIntent);  // Start the MainActivity
            finish();  // Close the current activity
        });
    }
}



//package com.example.matala2;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class QuizResultActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.quiz_results);
//
//        TextView resultText = findViewById(R.id.result_text); // TextView for displaying the result
//        Button restartButton = findViewById(R.id.restart_button); // Restart button
//
//        // Get the score and total questions from the intent passed from MainActivity
//        Intent intent = getIntent();
//        int score = intent.getIntExtra("score", 0);  // Current user's score
//        int totalQuestions = intent.getIntExtra("total_questions", 6);  // Total number of questions (default is 6)
//
//        // Create the result message
//        String resultMessage;
//        if (score == totalQuestions) {
//            // User answered all questions correctly
//            resultMessage = "You answered " + score + " out of " + totalQuestions + " questions correctly! Congrats!";
//        } else {
//            // User did not answer all questions correctly
//            resultMessage = "You answered " + score + " out of " + totalQuestions + " questions correctly.\nYou can beat this score! It's not your best attempt yet.";
//        }
//
//        // Display the result message on the TextView
//        resultText.setText(resultMessage);
//
//        // Set up the restart button to start a new quiz
//        restartButton.setOnClickListener(v -> {
//            Intent restartIntent = new Intent(QuizResultActivity.this, MainActivity.class);
//            startActivity(restartIntent);  // Start the MainActivity
//            finish();  // Close the current activity
//        });
//    }
//}
//
//
////package com.example.matala2;
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////import android.widget.TextView;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////public class QuizResultActivity extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.quiz_results);  // Ensure that you have this layout with proper views
////
////        TextView resultText = findViewById(R.id.result_text); // TextView for displaying result
////        Button restartButton = findViewById(R.id.restart_button); // Restart button
////
////        // Get the score and total questions from the intent that was passed from MainActivity
////        Intent intent = getIntent();
////        int score = intent.getIntExtra("score", 0);  // Score value
////        int totalQuestions = intent.getIntExtra("total_questions", 0);  // Total number of questions
////
////        // Display the result message on the TextView
////        String resultMessage = "You answered " + score + " out of " + totalQuestions + " questions correctly!";
////        resultText.setText(resultMessage);
////
////        // Setting an OnClickListener for the restart button
////        restartButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // When the button is clicked, navigate back to the MainActivity (start a new quiz)
////                Intent restartIntent = new Intent(QuizResultActivity.this, MainActivity.class);
////                startActivity(restartIntent);  // Start the MainActivity
////                finish();  // Finish the current activity to prevent the user from coming back to the result screen
////            }
////        });
////    }
////}
////
////
////
////////package com.example.matala2;
////////
////////import android.content.Intent;
////////import android.os.Bundle;
////////import android.view.View;
////////import android.widget.Button;
////////import android.widget.TextView;
////////
////////import androidx.appcompat.app.AppCompatActivity;
////////
////////public class QuizResultActivity extends AppCompatActivity {
////////
////////    @Override
////////    protected void onCreate(Bundle savedInstanceState) {
////////        super.onCreate(savedInstanceState);
////////        setContentView(R.layout.quiz_results);
////////
////////        TextView resultText = findViewById(R.id.result_text);
////////        Button restartButton = findViewById(R.id.restart_button);
////////        // Get the score from the intent
////////        Intent intent = getIntent();
////////        int score = intent.getIntExtra("score", 0);
////////        int totalQuestions = intent.getIntExtra("total_questions", 0);
////////
////////        // Display the result
////////        String resultMessage = "You answered " + score + " out of " + totalQuestions + "!";
////////        resultText.setText(resultMessage);
////////
////////
////////        restartButton.setOnClickListener(new View.OnClickListener() {
////////            @Override
////////            public void onClick(View v) {
////////                Intent restartIntent = new Intent(QuizResultActivity.this, MainActivity.class);
////////                startActivity(restartIntent);
////////                finish(); // Close the QuizResultActivity
////////            }
////////        });
////////
////////    }
////////
////////
////////}
