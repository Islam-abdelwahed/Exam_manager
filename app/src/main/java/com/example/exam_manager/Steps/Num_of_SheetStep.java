package com.example.exam_manager.Steps;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import ernestoyaquello.com.verticalstepperform.Step;

public class Num_of_SheetStep extends Step<Integer> {
    EditText e;

    public Num_of_SheetStep(String title) {
        super(title);
    }

    @Override
    public Integer getStepData() {
        int i;
        if(e.getText().toString().isEmpty()) i=0;
        else  i=(Integer) Integer.valueOf(e.getText().toString());
        return i;
    }

    @Override
    public String getStepDataAsHumanReadableString() {return null;
    }

    @Override
    protected void restoreStepData(Integer data) {

    }

    @Override
    protected IsDataValid isStepDataValid(Integer stepData) {
        boolean isNameValid = stepData > 0;
        String errorMessage = !isNameValid ? "You must Enter number" : "";
        return new  IsDataValid(isNameValid, errorMessage);
    }

    @Override
    protected View createStepContentLayout() {
       e=new EditText(getContext());
       e.setSingleLine(true);
       e.setInputType(TYPE_CLASS_NUMBER);
       e.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
            markAsCompletedOrUncompleted(true);
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
       return e;
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
