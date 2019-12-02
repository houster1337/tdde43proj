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
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PasswordValidator extends LinearLayout {

    private EditText input;
    private TextView output;
    private String pw;
    private int grade;
    private PasswordStrengthMeter passwordStrengthMeter;
    private Validator validator;


    public PasswordValidator(Context context) {
        super(context);
        setUpUI();
    }

    public PasswordValidator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpUI();
    }

    public PasswordValidator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpUI();
    }

    public void setUpUI() {
        View layout = LayoutInflater.from(getContext())
                .inflate(R.layout.password_validator,(ViewGroup) getParent());

        input = layout.findViewById(R.id.pwfield);
        output = layout.findViewById(R.id.pwgrad);
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
                System.out.println("asdf");
               passwordStrengthMeter = new PasswordStrengthMeter(defaultValidate(pw), output);

            }
        });

        addView(layout);

    }

        public int defaultValidate(String pw){

            boolean len = false;
            boolean uc = false;
            boolean lc = false;
            boolean num = false;

            if(pw.length() > 8){
                len = true;
                for(int i = 0; i<pw.length(); i++){
                    char a = pw.charAt(i);
                    if(Character.isUpperCase(a)) {

                        uc = true;
                    }
                        if(Character.isDigit(a)){
                            num = true;
                        }
                        if(Character.isLowerCase(a)){
                            lc = true;
                        }
                    }
        }
            if (len && uc && num && lc){
                grade = 3;
            } else if(len && uc && lc || len && num && lc || num && uc && lc){
                grade = 2;
            } else if(len || uc || num) {
                grade = 1;
            }else{
                grade = 0;
            }
            return grade;
    }


    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
