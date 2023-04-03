package com.example.qyuizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question1 extends AppCompatActivity implements View.OnClickListener{
    public Button next , submit;
    public Button op1 , op2 , op3 , op4;
    public TextView ques ;
    int currQ=0;
    int score=0;
    String selectedAns = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        ques = findViewById(R.id.question);
        next = findViewById(R.id.nextbtn);
        submit = findViewById(R.id.prevbtn);
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

//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent ques2intent = new Intent(Question1.this , question2.class);
//                startActivity(ques2intent);
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        op1.setBackgroundColor(Color.rgb(31 , 224 ,128));
        op2.setBackgroundColor(Color.rgb(31 , 224 ,128));
        op3.setBackgroundColor(Color.rgb(31 , 224 ,128));
        op4.setBackgroundColor(Color.rgb(31 , 224 ,128));

        Button clickedBtn = (Button) view;

        if(clickedBtn.getId()==R.id.nextbtn){
            if(selectedAns.equals(QuestionAnswer.answers[currQ])){
                score++;
            }
            currQ++;
            loadNewQuestion();
        }else{
            selectedAns = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.GRAY);
        }

    }

    void loadNewQuestion(){
        ques.setText(QuestionAnswer.questions[currQ]);
        op1.setText(QuestionAnswer.options[currQ][0]);
        op2.setText(QuestionAnswer.options[currQ][1]);
        op3.setText(QuestionAnswer.options[currQ][2]);
        op4.setText(QuestionAnswer.options[currQ][3]);


    }

}