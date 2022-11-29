package com.example.cullcul;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private SeekBar sc, sc1, sc2;
    String s;
    Integer q,q1,q2;
    private TextView mTextView,mTextView1,mTextView2;
    public static final String VALUE = "key";
    public static final String VALUE1 = "key1";
    public static final String VALUE2 = "key2";

    private ActivityResultLauncher launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == MainActivity2.CODE){
                    String str = result.getData().getStringExtra(MainActivity2.KEY2);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        sc = findViewById(R.id.seekBar);
        mTextView = findViewById(R.id.textView5);
        mTextView.setText("0 ₽");
        sc.setProgress(0);
        sc.setMax(2000000);
        sc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i/100000;
                i = i*100000;
                mTextView.setText(String.valueOf(i)+" ₽");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                q = seekBar.getProgress();
                q = q / 100000;
                q = q * 100000;


            }
        });
//        int s_1 = Integer.parseInt(s);
        mTextView1 = findViewById(R.id.textView9);
        mTextView1.setText("0"+" Год");


        sc1 = findViewById(R.id.seekBar2);
        sc1.setProgress(0);
        sc1.setMax(3);
        sc1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTextView1.setText(String.valueOf(i)+" Год");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                q1 = seekBar.getProgress();


            }
        });
        sc2 = findViewById(R.id.seekBar3);
        mTextView2 = findViewById(R.id.textView10);
        mTextView2.setText("0 ₽");


        sc2 = findViewById(R.id.seekBar3);
        sc2.setProgress(0);
        sc2.setMax(200000);
        sc2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i/5000;
                i = i*5000;
                mTextView2.setText(String.valueOf(i)+" ₽");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                q2 = seekBar.getProgress();
                q2 = q2 / 5000;
                q2 = q2 * 5000;


            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // намерение - явное

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra(VALUE,q);
                intent.putExtra(VALUE1,q1);
                intent.putExtra(VALUE2,q2);
                MainActivity.this.startActivity(intent);
//                launcher.launch(intent);
            }
        });


    }
}