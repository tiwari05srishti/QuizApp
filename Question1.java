package com.example.qyuizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;


public class Question1 extends AppCompatActivity implements View.OnClickListener{
    public Button next , submit;
    public Button op1 , op2 , op3 , op4;
    public TextView ques ;
    int currQ=0;
    int score=0 , highscore = 0;
    int totalQ = QuestionAnswer.questions.length;
    public static final String Extra_number = "quizzer.Question1.finalScore";
    public static final String Key_highscore = "KEY_HIGHSCORE";
    public String score_string ;
    String selectedAns = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        ques = findViewById(R.id.question);
        next = findViewById(R.id.nextbtn);
        submit = findViewById(R.id.submitbtn);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.opt3);
        op4 = findViewById(R.id.opt4);


        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);
        op4.setOnClickListener(this);
        next.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {
        op1.setBackgroundColor(Color.rgb(152 , 152 ,152));
        op2.setBackgroundColor(Color.rgb(152 , 152 ,152));
        op3.setBackgroundColor(Color.rgb(152 , 152 ,152));
        op4.setBackgroundColor(Color.rgb(152 , 152 ,152));

        Button clickedBtn = (Button) view;

        if(clickedBtn.getId()==R.id.submitbtn){
            finishQuiz();
        }
        else if(clickedBtn.getId()==R.id.nextbtn){
            if(selectedAns.equals(QuestionAnswer.answers[currQ])){
                score++;
            }
            currQ++;
            loadNewQuestion();
        }else{
            selectedAns = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.rgb(31 , 224 , 128));
        }

    }

    void loadNewQuestion(){
        if(currQ==totalQ){
            finishQuiz();
            return;
        }

        ques.setText(QuestionAnswer.questions[currQ]);
        op1.setText(QuestionAnswer.options[currQ][0]);
        op2.setText(QuestionAnswer.options[currQ][1]);
        op3.setText(QuestionAnswer.options[currQ][2]);
        op4.setText(QuestionAnswer.options[currQ][3]);


    }


    void finishQuiz(){

        score_string = "0"+ score;
        //for updating high score if current score is greater then prev high score

//        if(score>highscore){
//            highscore=score;
//        }
        // for saving highest score

        SharedPreferences sharedPreferences = getSharedPreferences("HIGHSCORE" , MODE_PRIVATE);
        SharedPreferences.Editor spe = sharedPreferences.edit();
        int prevHS = sharedPreferences.getInt("KEY_HIGHSCORE", 0);
        if(prevHS<score){
            highscore=score;
        }else{
            highscore=prevHS;
        }
        spe.putInt(Key_highscore , highscore);
        spe.apply();
        Intent fscore = new Intent(Question1.this , Finalscore.class);
        fscore.putExtra(Extra_number , score_string);
        startActivity(fscore);
    }

}
