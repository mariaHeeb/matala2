package com.example.matala2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TheQuizQuestions {

    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What does HTML stand for?",
                Arrays.asList("Hyper Text Markup Language", "High Text Markup Language", "Hyperlinks and Text Marking Language", "Home Tool Markup Language"),
                "Hyper Text Markup Language"));
        questions.add(new Question("What is the correct syntax to print a message in Java?",
                Arrays.asList("echo('Hello World')", "console.log('Hello World')", "System.out.println('Hello World')", "print('Hello World')"),
                "System.out.println('Hello World')"));
        questions.add(new Question("Which programming language is known as the language of the web?",
                Arrays.asList("Java", "Python", "JavaScript", "C++"),
                "JavaScript"));
        questions.add(new Question("What does CSS stand for?",
                Arrays.asList("Cascading Style Sheets", "Creative Style Sheets", "Computer Style Sheets", "Coded Style Sheets"),
                "Cascading Style Sheets"));
        questions.add(new Question("Which of the following is used to define a variable in Python?",
                Arrays.asList("let", "var", "int", "a ="),
                "a ="));
        questions.add(new Question("Which keyword is used to declare a function in JavaScript?",
                Arrays.asList("def", "function", "func", "declare"),
                "function"));

        return questions;
    }

}
