package com.example.project;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PasswordValidator extends LinearLayout {

    private EditText input;
    private TextView output;
    private String pw;
    private int grade;


    public PasswordValidator(Context context) {
        super(context);
    }

    public PasswordValidator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PasswordValidator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUpUI() {
        input = findViewById(R.id.pwfield);
        output = findViewById(R.id.pwgrad);
        pw = input.toString();
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

        public void validate(String pw){

            boolean len = false;
            boolean uc = false;
            boolean num = false;

            if(pw.length() > 8){
                len = true;
                for(int i = 0; i<pw.length(); i++){
                    char a = pw.charAt(i);
                    if(Character.isUpperCase(a)){
                        uc = true;
                        if(Character.isDigit(a)){
                            num = true;
                        }
                    }
                }
        }
            if (len && uc && num){
                grade = 3;
            } else if(len && uc || len && num || num && uc){
                grade = 2;
            } else if(len || uc || num) {
                grade = 1;
            }else{
                grade = 0;
            }
    }




}
