package com.example.exam_manager.Steps;

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
        return null;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    protected void restoreStepData(Integer data) {

    }

    @Override
    protected IsDataValid isStepDataValid(Integer stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
       e=new EditText(getContext());
       e.setSingleLine(true);
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
