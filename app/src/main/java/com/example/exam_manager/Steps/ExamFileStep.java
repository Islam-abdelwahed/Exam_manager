package com.example.exam_manager.Steps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.exam_manager.R;
import ernestoyaquello.com.verticalstepperform.Step;

public class ExamFileStep extends Step<String>  {
   public static Button b;
    @SuppressLint("StaticFieldLeak")
   public static TextView e;
   public static Context c;

    public ExamFileStep(String title, Context c) {
        super(title);
        ExamFileStep.c =c;
    }

    @Override
    public String getStepData() {
        String userName = e.getText().toString();
        return userName != null ? userName : "";    }

    @Override
    public String getStepDataAsHumanReadableString() {
        String userName = getStepData();
        return !userName.isEmpty() ? userName : "(Empty)";    }

    @Override
    protected void restoreStepData(String data) {

    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        boolean isNameValid = stepData.length() >= 1;
        String errorMessage = !isNameValid ? "You must select a pdf Document" : "";
        return new  IsDataValid(isNameValid, errorMessage);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected View createStepContentLayout() {
        LinearLayout layout=new LinearLayout(getContext());
        b=new Button(getContext());
        e=new TextView(getContext());
        b.setText("Upload PDF");
        e.setTextColor(R.color.teal_200);
        layout.setOrientation(LinearLayout.VERTICAL);
        b.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("*/*");
            ((Activity)(c)).startActivityForResult(i, 1);
        });
        layout.addView(b,0);
        layout.addView(e,1);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                markAsCompletedOrUncompleted(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return layout;
    }

    @Override
    protected void onStepOpened(boolean animated) {

    }

    @Override
    protected void onStepClosed(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {
        isStepDataValid(e.getText().toString());
    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }

    }

