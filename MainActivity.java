package com.example.qyuizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public Button buttonstrt;
    public Button highscore;
    public TextView textview_hs;
    public String text_hs ;
    public int onclick_count =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonstrt =  findViewById(R.id.startbtn);
        highscore =  findViewById(R.id.highscores);
        textview_hs = findViewById(R.id.textView4);

        buttonstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ques1intent = new Intent(MainActivity.this , Question1.class);
                startActivity(ques1intent);
            }
        });

        SharedPreferences sp = getSharedPreferences("HIGHSCORE" , MODE_PRIVATE);
        int hs = sp.getInt("KEY_HIGHSCORE", 0);
        String hs_str = ""+hs ;
        text_hs = hs_str +"/5";

        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick_count++;
                if(onclick_count%2!=0){
                    textview_hs.setText(text_hs);
                }else{
                    textview_hs.setText("");
                }

            }
        });




    }
}
