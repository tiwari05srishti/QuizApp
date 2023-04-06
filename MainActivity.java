package com.example.qyuizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    public Button buttonstrt;
    public Button highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonstrt =  findViewById(R.id.startbtn);
        highscore =  findViewById(R.id.highscores);


        buttonstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ques1intent = new Intent(MainActivity.this , Question1.class);
                startActivity(ques1intent);
            }
        });
//        highscore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //
//            }
//        });




    }
}
