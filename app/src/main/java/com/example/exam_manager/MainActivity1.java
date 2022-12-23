package com.example.exam_manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import com.example.exam_manager.Steps.CodesFileStep;
import com.example.exam_manager.Steps.ExamFileStep;
import com.example.exam_manager.Steps.Num_of_SheetStep;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;

public class MainActivity1 extends Activity implements StepperFormListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ExamFileStep examFileStep=new ExamFileStep("Select Exam File",this);
        CodesFileStep codesFileStep=new CodesFileStep("Select Codes File",this);
        Num_of_SheetStep num_of_sheetStep=new Num_of_SheetStep("Enter number of exam sheets");

        VerticalStepperFormView verticalStepperForm = findViewById(R.id.stepper_form);
        verticalStepperForm.setup(this,examFileStep ,codesFileStep,num_of_sheetStep )
                .allowNonLinearNavigation(false)
                .displayBottomNavigation(false)
                .lastStepNextButtonText("Upload Exam")
                .displayCancelButtonInLastStep(true)
                .init();
    }

    @Override
    public void onCompletedForm() {
     AlertDialog.Builder builder=new AlertDialog.Builder(this);
     builder.setMessage("THank You");
     builder.create();
     builder.show();

     new Upload_file().execute(ExamFileStep.e.getText().toString());

    }

    @Override
    public void onCancelledForm() {
        finish();
    }

    @Override
    public void onStepAdded(int index, Step<?> addedStep) {

    }

    @Override
    public void onStepRemoved(int index) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodesFileStep.onActivityResult(requestCode, resultCode, data);
        ExamFileStep.onActivityResult(requestCode, resultCode, data);
    }
}
