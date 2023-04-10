package com.example.qyuizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;



public class Finalscore extends AppCompatActivity {
    public TextView text_score , text_highScore , text_greeting ;
    public Button restart;
    public String set_greeting , hs_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscore);

        Intent intent = getIntent();

        String nums = intent.getStringExtra(Question1.Extra_number);
        text_score = findViewById(R.id.textView_score);
        text_highScore = findViewById(R.id.textView3);
        text_greeting = findViewById(R.id.greet);
        restart = findViewById(R.id.restartbutton);

        text_score.setText(nums);
        SharedPreferences sp = getSharedPreferences("HIGHSCORE" , MODE_PRIVATE);
        int HS = sp.getInt("KEY_HIGHSCORE" , 0);
        hs_string = "0"+HS;
        text_highScore.setText(hs_string);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Finalscore.this , Question1.class);
                startActivity(intent2);
            }
        });


        int x = Integer.parseInt(nums);
        if(x>=3){
            set_greeting ="Congratulations!!";
        }else{
            set_greeting = "Better Luck next time";
        }
        text_greeting.setText(set_greeting);







    }
}
