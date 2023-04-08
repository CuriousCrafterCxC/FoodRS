package com.example.foodrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight, editTextAge;
    private RadioGroup radioGroupGender;
    private Spinner spinnerLifestyle;
    private Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerLifestyle = findViewById(R.id.spinnerLifestyle);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = editTextWeight.getText().toString();
                String height = editTextHeight.getText().toString();
                String age = editTextAge.getText().toString();
                int genderId = radioGroupGender.getCheckedRadioButtonId();
                String gender = "";
                switch (genderId) {
                    case R.id.radioButtonMan:
                        gender = "Man";
                        break;
                    case R.id.radioButtonWoman:
                        gender = "Woman";
                        break;
                }
                String lifestyle = spinnerLifestyle.getSelectedItem().toString();

                if (!TextUtils.isEmpty(weight) && !TextUtils.isEmpty(height) && !TextUtils.isEmpty(age)) {
                    if (isNumeric(weight) && isNumeric(height) && isNumeric(age)) {
                        SharedPreferences sharedPref = getSharedPreferences("Person_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("Weight", weight);
                        editor.putString("Height", height);
                        editor.putString("Age", age);
                        editor.putString("Gender", gender);
                        editor.putString("Lifestyle", lifestyle);
                        editor.apply();
                        Toast.makeText(MainActivity.this, "Data saved successfully.", Toast.LENGTH_SHORT).show();

                        // jump other activity
//                        Intent intent = new Intent(MainActivity.this, FoodDetail.class);
//                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}