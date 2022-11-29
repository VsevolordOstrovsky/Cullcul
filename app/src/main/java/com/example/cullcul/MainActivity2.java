package com.example.cullcul;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button btn;

    private TextView textView8, textView12;
    public static final int CODE = 2;
    public static final String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




//        Bundle bundle = getIntent().getExtras();
//        String s = bundle.getString(MainActivity.VALUE);
        Intent mIntent = getIntent();
        Integer s_1 = mIntent.getIntExtra("key",0);
        Integer s_2 = mIntent.getIntExtra("key1",0);
        Integer s_3 = mIntent.getIntExtra("key2",0);
        double umm = s_1;
        int mes = s_2 * 12;
        int mes_1 = mes;
        double pr = 0;
        double cons = 0.0025;
        for(int i = 0; i < mes; i++){
            if (i == 0){
                umm = umm*(1+0.0025);}
            else{
                umm = umm*(1+0.0025)+s_3;
                pr += s_3;
            }

        }

        String w1 = String.valueOf(Math.floor(umm * 100)/100);
        String w2 = String.valueOf(Math.floor((umm - (s_1 + pr))*100)/100);
        String w3 = String.valueOf(s_3);
        textView12 = findViewById(R.id.textView12);
        textView12.setText(w1);


        textView8 = findViewById(R.id.textView8);
        textView8.setText(w2);




    }
}