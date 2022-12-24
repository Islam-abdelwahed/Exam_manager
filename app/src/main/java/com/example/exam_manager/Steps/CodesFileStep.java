package com.example.exam_manager.Steps;

import static android.app.Activity.RESULT_OK;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.exam_manager.R;
import java.io.File;
import ernestoyaquello.com.verticalstepperform.Step;

public class CodesFileStep extends Step<String> {
    public Context c;
    public Button b;
    @SuppressLint("StaticFieldLeak")
    static TextView e;

    public CodesFileStep(String title, Context c) {
        super(title);
        this.c=c;
    }

    @Override
    public String getStepData() {
        return e.getText().toString();    }

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
        String errorMessage = !isNameValid ? "You must select an Excel Document" : "";
        return new  IsDataValid(isNameValid, errorMessage);
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    protected View createStepContentLayout() {
        LinearLayout layout=new LinearLayout(getContext());
        b=new Button(getContext());
        e=new TextView(getContext());
        b.setText("Upload Excel");
        e.setTextColor(R.color.teal_200);
        layout.setOrientation(LinearLayout.VERTICAL);

        b.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            ((Activity)(c)).startActivityForResult(i, 2);
        });

        layout.addView(b, 0);
        layout.addView(e, 1);

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

    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }


    }
