package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 final String TAG = "lifecycle";
 private int count = 0;
 private TextView tvCounter;
 private String KEY_NUMBER = "number";
 Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        tvCounter = findViewById(R.id.tv_counter);
        if (savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_NUMBER, 0);
        }
        updateCounter();


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Log.d(TAG, "Activity создано");


//        View view = findViewById(R.id.HelloWorld);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, getString(R.string.Hello), Toast.LENGTH_LONG).show();
//            }
//        });

    }

    private void updateCounter(){
        count++;
        tvCounter.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_NUMBER, count);
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Activity сoхраняет значение счетчика");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity становиться видимым");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity получает фокус (состояние Resumed)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity приостановлено (состояние Paused)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity остановлено (состояние Stopped)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity уничтожено");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);

    }
}
