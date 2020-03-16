package com.example.simplecalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity2 extends AppCompatActivity {
    TextView resultSecondActivity;
    private String getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        resultSecondActivity = findViewById(R.id.secondResult);

    }

    public void onClick(View view) {
        Intent toOpenCul = new Intent(MainActivity2.this, MainActivity.class);
        startActivityForResult(toOpenCul, 15);
    }
    public void share(View view) {
        if (getResult!=null) {
            Intent toOpenShare = new Intent();
            toOpenShare.setAction(Intent.ACTION_SEND);
            toOpenShare.putExtra(Intent.EXTRA_TEXT, getResult);
            toOpenShare.setType("text/plain");
            if (toOpenShare.resolveActivity(getPackageManager()) != null) {
                startActivity(toOpenShare);
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 15 && resultCode == RESULT_OK && data != null) {
            getResult = data.getStringExtra("Key");
            resultSecondActivity.setText(getResult);
            Log.d("ooo", "onActivityResult: ");
        }
    }
}
