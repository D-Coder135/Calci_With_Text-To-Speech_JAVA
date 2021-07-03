package com.example.calci_with_text_to_speech_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        add = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mul = findViewById(R.id.button3);
        div = findViewById(R.id.button4);

        textToSpeech = new TextToSpeech(this, status -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.5f);
        });

        add.setOnClickListener(v -> {
            String firstInput = editText1.getText().toString();
            String secondInput = editText2.getText().toString();
            Float firstInputFloat = Float.parseFloat(firstInput);
            Float secondInputFloat = Float.parseFloat(secondInput);
            float result = firstInputFloat + secondInputFloat;
            String resultString = Float.toString(result);
            resultView.setText(resultString);
            textToSpeech.speak(resultString, TextToSpeech.QUEUE_FLUSH, null);
        });

        sub.setOnClickListener(v -> {
            String firstInput = editText1.getText().toString();
            String secondInput = editText2.getText().toString();
            Float firstInputFloat = Float.parseFloat(firstInput);
            Float secondInputFloat = Float.parseFloat(secondInput);
            float result = firstInputFloat - secondInputFloat;
            String resultString = Float.toString(result);
            resultView.setText(resultString);
            textToSpeech.speak(resultString, TextToSpeech.QUEUE_FLUSH, null);
        });

        mul.setOnClickListener(v -> {
            String firstInput = editText1.getText().toString();
            String secondInput = editText2.getText().toString();
            Float firstInputFloat = Float.parseFloat(firstInput);
            Float secondInputFloat = Float.parseFloat(secondInput);
            float result = firstInputFloat * secondInputFloat;
            String resultString = Float.toString(result);
            resultView.setText(resultString);
            textToSpeech.speak(resultString, TextToSpeech.QUEUE_FLUSH, null);
        });

        div.setOnClickListener(v -> {
            String firstInput = editText1.getText().toString();
            String secondInput = editText2.getText().toString();
            Float firstInputFloat = Float.parseFloat(firstInput);
            Float secondInputFloat = Float.parseFloat(secondInput);
            float result = firstInputFloat / secondInputFloat;
            String resultString = Float.toString(result);
            resultView.setText(resultString);
            textToSpeech.speak(resultString, TextToSpeech.QUEUE_FLUSH, null);
        });
    }
}