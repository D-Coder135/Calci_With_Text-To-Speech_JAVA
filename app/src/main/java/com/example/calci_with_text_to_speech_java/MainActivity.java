package com.example.calci_with_text_to_speech_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button add, sub, mul, div;
    TextView resultView;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        add = (Button)findViewById(R.id.button);
        sub = (Button)findViewById(R.id.button2);
        mul = (Button)findViewById(R.id.button3);
        div = (Button)findViewById(R.id.button4);

        textToSpeech = new TextToSpeech(this, new OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ENGLISH);
                textToSpeech.setSpeechRate(0.5f);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstInput = editText1.getText().toString();
                String secondInput = editText2.getText().toString();
                Float firstInputFloat = Float.parseFloat(firstInput);
                Float secondInputFloat = Float.parseFloat(secondInput);
                Float result = firstInputFloat + secondInputFloat;
                String resultString = Float.toString(result);
            }
        });
    }
}