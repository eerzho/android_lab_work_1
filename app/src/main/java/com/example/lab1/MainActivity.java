package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView resultMessage;
    double total = 0;
    String resultString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        resultMessage = findViewById(R.id.resultMessage);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println(input.getText());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceType")
            @Override
            public void afterTextChanged(Editable s) {
                Editable input_text = input.getText();
                int per;
                if ("".contentEquals(input_text)) {
                    System.out.println("equal");
                    per = 0;
                } else {
                    System.out.println("no equal");
                    per = Integer.parseInt(String.valueOf(input_text));
                }
                total = 0;
                resultString = "";
                if (per > 16) {
                    per -= 16;
                    total += 3;
                    resultString += "Base coast: " + total + " $\n";
                    resultMessage.setText(resultString);
                    if (per > 30) {
                        per -= 30;
                        total += 4;
                        resultString += "Added coast: 4.0 $\n";
                        resultMessage.setText(resultString);
                        double per2 = per / 4;
                        per2 *= 0.5;
                        total += per2;
                        resultString += "Total coast: " + total + " $\n";
                        resultMessage.setText(resultString);
                    }
                } else if (per == 0) {
                    resultMessage.setText("");
                } else {
                    total += 3;
                    resultString += "Base coast: " + total + " $\n";
                    resultMessage.setText(resultString);
                }
            }
        });
    }
}