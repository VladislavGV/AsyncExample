package ru.synergy.asyncexample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThreadExample extends AppCompatActivity {

    int mCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                // do time consuming operations here
            }
        }).start();*/
    }

    public void onClick(View v) {


        long endTime = System.currentTimeMillis() + 20 + 1000;
        while (System.currentTimeMillis()< endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
            TextView mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
            mInfoTextView.setText("Сегодня ворон было " + mCounter++ + "штук");
        }
    }

   /* private Runnable doInBackgroundProcessing = new Runnable(){

        @Override
        public void run() {
            backgroundThreadProcessing();
        }
    };

    private void backgroundThreadProcessing() {
        // трудоемкие операции
    }

    private void mainProcessing(){
        Thread thread = new Thread(null, doInBackgroundProcessing, "Background");
    }*/
