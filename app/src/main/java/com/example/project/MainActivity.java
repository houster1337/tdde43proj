package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Object PasswordStrengthMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_validator);
        final PasswordValidator pw = findViewById(R.id.pwval);
        pw.setValidator(new PasswordStrengthMeter());





    }
}
