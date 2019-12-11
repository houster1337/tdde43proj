package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Field extends LinearLayout{
    private View view;
    private String label;
    private Context context;
    private EditText editText;
    private MainActivity mainActivity;

    public DataManip getDataManip() {
        return dataManip;
    }

    private DataManip dataManip;

    public Field(Context context) {
        super(context);
        if (view != null) {
            init();
        }
    }

    public Field(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (view != null) {
            init();
        }

    }

    public Field(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Field(Context context, String label, View view, DataManip dataManip) {
        this(context);
        this.view = view;
        this.label = label;
        this.dataManip = dataManip;
        init();
    }

    /**
     * Creates a TextView with a given label next to the view and adds them both to the form.
     */
    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        final TextView textView = new TextView(getContext());
        textView.setText(label);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(view);
        addView(textView);

    }

}
