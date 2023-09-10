package com.example.temperatureconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button submitbtn,resetbtn;
    TextView show_output;
    EditText get_input;
    RadioButton c2f,f2c;
    Double x;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitbtn = (Button) findViewById(R.id.submitbtn);
        show_output = (TextView) findViewById(R.id.show_output);
        get_input = (EditText) findViewById(R.id.get_input);
        c2f = (RadioButton) findViewById(R.id.c2f);
        f2c = (RadioButton) findViewById(R.id.f2c);
        resetbtn = (Button) findViewById(R.id.resetbtn);
    submitbtn.setOnClickListener(view -> {
        if(get_input.getText().toString().isEmpty()){
            show_output.setText("Please give Temperature");

        }
        else {
           x = Double.parseDouble(String.valueOf(get_input.getText()));
           if(c2f.isChecked()){
               x = (x*9)/5+32;
               x = Double.parseDouble(new DecimalFormat("##.###").format(x));
               show_output.setText(x +"Degree F");
           } else if (f2c.isChecked()) {
               x = (x-32)*5/9;
               x = Double.parseDouble(new DecimalFormat("##.###").format(x));
               show_output.setText(x +"Degree C");

           }
           else {
               show_output.setText("Please Select An Option");
           }
        }
    });
    resetbtn.setOnClickListener(view -> {
        show_output.setText("0.0");
        get_input.setText("");
        c2f.setChecked(false);
        f2c.setChecked(false);
    });
    }
}