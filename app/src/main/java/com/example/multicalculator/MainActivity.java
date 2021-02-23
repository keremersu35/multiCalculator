package com.example.multicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.multicalculator.binaryhexa.binaryHexadecimalActivity;
import com.example.multicalculator.decimalhexa.decimalHexadecimalActivity;

public class MainActivity extends AppCompatActivity {

    TextView multicalculatorText;
    Button binaryDecimalButton, binaryHexadecimalButton, decimalHexadecimalButton, calculatorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multicalculatorText = findViewById(R.id.multicalculatorText);
        binaryDecimalButton = findViewById(R.id.binaryDecimalButton);
        binaryHexadecimalButton = findViewById(R.id.binaryHexadecimalButton);
        decimalHexadecimalButton = findViewById(R.id.decimalHexadecimalButton);
        calculatorButton = findViewById(R.id.calculatorButton);

        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#83C5BE"));

        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public void calculatorClicked(View view){
        Intent intent = new Intent(MainActivity.this,calculatorActivity.class);
        startActivity(intent);
    }

    public void binaryDecimalClicked(View view){
        Intent intent = new Intent(MainActivity.this,binaryDecimalActivity.class);
        startActivity(intent);
    }

    public void binaryHexaClicked(View view){
        Intent intent = new Intent(MainActivity.this, binaryHexadecimalActivity.class);
        startActivity(intent);
    }

    public void decimalHexaClicked(View view){
        Intent intent = new Intent(MainActivity.this, decimalHexadecimalActivity.class);
        startActivity(intent);
    }
}