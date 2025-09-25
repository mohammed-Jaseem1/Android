package com.example.calculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private TextView resultTextView;

    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // make sure your XML file is named activity_main.xml

        editText1 = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        resultTextView = findViewById(R.id.textView);

        btnAdd = findViewById(R.id.button);
        btnSubtract = findViewById(R.id.button2);
        btnMultiply = findViewById(R.id.button3);
        btnDivide = findViewById(R.id.button4);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String input1 = editText1.getText().toString().trim();
        String input2 = editText2.getText().toString().trim();

        if (input1.isEmpty() || input2.isEmpty()) {
            resultTextView.setText("Please enter both numbers");
            return;
        }

        double num1, num2;

        try {
            num1 = Double.parseDouble(input1);
            num2 = Double.parseDouble(input2);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
            return;
        }

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    resultTextView.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                resultTextView.setText("Unknown operation");
                return;
        }

        resultTextView.setText(String.valueOf(result));
    }
}
