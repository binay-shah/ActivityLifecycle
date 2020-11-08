package com.example.activitylifecyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";

    private Button dialogBtn;
    private Button secondActivityBtn;
    private TextView textView;
    int sum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogBtn = findViewById(R.id.button);
        secondActivityBtn = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        textView.setText(""+sum);
        Log.d(TAG, "onCreate");
        //Log.d(TAG, "sum: "+ sum);

        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum + 1;
                Log.d(TAG, "sum: "+ sum);
                textView.setText(""+sum);
            }
        });

        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        if(savedInstanceState != null){
            sum = savedInstanceState.getInt("SUM_KEY");
            Log.d(TAG, "Sum after rotation: "+sum );
            textView.setText(""+sum);
        }

        if(savedInstanceState == null){
            Log.d(TAG, " savedInstanceState is null");
            //sum = savedInstanceState.getInt("SUMKEY");
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putInt("SUM_KEY", sum);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "on Back Pressed");
        super.onBackPressed();

    }
}
