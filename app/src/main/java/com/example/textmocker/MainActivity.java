package com.example.textmocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mockText(View view) {
        TextInputEditText textIn = (TextInputEditText) findViewById(R.id.textIn);
        TextView textOut = (TextView) findViewById(R.id.textOut);

        textOut.setText(textIn.getText());
    }
}