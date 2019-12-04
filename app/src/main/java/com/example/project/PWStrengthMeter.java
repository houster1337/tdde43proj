package com.example.project;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PWStrengthMeter extends LinearLayout {

    private EditText input;
    private TextView output;
    private String pw;
    private int grade;
    private MyGUI myGUI;
    private Validator validator;
    private String pw2;
    private ProgressBar progressBar;


    public PWStrengthMeter(Context context) {
        super(context);
        setUpUI();
    }

    public PWStrengthMeter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpUI();
    }

    public PWStrengthMeter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpUI();
    }

    public void setUpUI() {
        View layout = LayoutInflater.from(getContext())
                .inflate(R.layout.password_validator,(ViewGroup) getParent());

        input = layout.findViewById(R.id.pwfield);
        output = layout.findViewById(R.id.pwgrad);
        progressBar = layout.findViewById(R.id.progressBar);

       // pw = input.toString();

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int grade = validator.validate(editable.toString());
                myGUI = new MyGUI(grade, output, progressBar);

            }
        });

        addView(layout);

    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

}
