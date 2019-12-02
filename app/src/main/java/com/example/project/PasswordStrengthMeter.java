package com.example.project;

import android.graphics.Color;
import android.widget.TextView;

public class PasswordStrengthMeter implements Validator {

private int defaultValidate;
private TextView output;
String pwGrade;

    public PasswordStrengthMeter(int defaultValidate, TextView output) {
        this. defaultValidate = defaultValidate;
        this.output = output;
    }
    public PasswordStrengthMeter(){

    }

    @Override
   public String validate(int grade){

        switch(grade) {
            case 3:
                pwGrade = "Strong";
                output.setTextColor(Color.GREEN);
                break;
            case 2:
                pwGrade = "Good";
                output.setTextColor(Color.BLUE);

                break;

            case 1:
                pwGrade = "Fair";
                output.setTextColor(Color.YELLOW);

                break;
            case 0:
                pwGrade = "Weak";
                output.setTextColor(Color.RED);

                break;

        }
        output.setText(pwGrade);


       return "asdf";
   }
}

