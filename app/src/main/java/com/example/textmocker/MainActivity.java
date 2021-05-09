package com.example.textmocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random(System.currentTimeMillis());
    }

    public void mockText(View view) {
        TextInputEditText textIn = (TextInputEditText) findViewById(R.id.textIn);
        TextView textOut = (TextView) findViewById(R.id.textOut);

        String originalText = textIn.getText().toString();
        CharSequence mockedText = mockText(originalText);

        textOut.setText(mockedText);
        copyToClipboard(mockedText);
    }

    private CharSequence mockText(String text) {
        String result = "";

        for(char c : text.toCharArray()) {
            boolean isI = (c == 'i' || c == 'I');
            boolean capital = !isI && (random.nextInt(2) == 1);

            result += capital ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }

        return result;
    }

    private void copyToClipboard(CharSequence text) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Mocked Text", text);

        clipboard.setPrimaryClip(clip);
    }
}