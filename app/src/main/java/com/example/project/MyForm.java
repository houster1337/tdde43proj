package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyForm extends LinearLayout {

    private ArrayList<Field> list = new ArrayList<Field>();
    private LinearLayout.LayoutParams layoutParams;
    private Field field;

    public MyForm(Context context) {
        super(context);
        init();
    }

    public MyForm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyForm(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * Setup layoutParams for fields.
     */
    public void init(){
        layoutParams = new LayoutParams(LayoutParams. MATCH_PARENT, LayoutParams. WRAP_CONTENT);
        this.setOrientation(LinearLayout.VERTICAL);

    }

    /**
     * Adds field to application and adds the field to a Arraylist of all fields in the form.
     * @param field
     */
    public void addField(Field field){
        field.setLayoutParams(layoutParams);
        this.addView(field);
        list.add(field);
    }

    /**
     * @return getValue() from all fields in the form.
     */

    public List<String> getData(){
        List<String> s = new ArrayList<String>();
        for(Field f : list){
            s.add(f.getDataManip().getValue(field));
        }
        System.out.println(s);
        return s;

    }


    /**
     * Lets the user add logic to a certain field.
     * @param field Field that should be modified.
     */
    public void addLogic(Field field){

    }
}
