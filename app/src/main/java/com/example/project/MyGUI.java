package com.example.project;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyGUI{

    private int defaultValidate;
    private TextView output;
    String pwGrade;
    Context context;
    int grade;
    private ProgressBar progressBar;


    public MyGUI(int grade, TextView output, ProgressBar progressBar) {
        this.grade = grade;
        this.output = output;
        this.progressBar = progressBar;
        validate(grade);

    }

    public void validate(int grade){
        switch(grade) {
            case 4:
                setText("Strong", "#75F74C");
                break;
            case 3:
                setText("Good", "#1951F7");
                break;
            case 2:
                setText("Fair", "#F742D2");
                break;
            case 1:
                setText("Weak", "#F70000");
                break;
        }
        progressBar.setProgress(grade);
    }

    public void setText(String text, String color){
        output.setTextColor(Color.parseColor(color));
        output.setText(text);
        progressBar.getProgressDrawable().setColorFilter(
                 Color.parseColor(color), android.graphics.PorterDuff.Mode.SRC_IN);
    }

}

