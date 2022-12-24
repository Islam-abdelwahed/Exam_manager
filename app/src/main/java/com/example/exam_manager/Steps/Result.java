package com.example.exam_manager.Steps;

import static android.app.Activity.RESULT_OK;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

public class Result {

    public static void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uriObj = data.getData();
            String uriPath = uriObj.getPath();
            File file = new File(uriPath);
            String fullFilePath = file.getPath();
            final String[] split = fullFilePath.split(":");
            String fullFilePathResult = split[1];
            if (requestCode == 2 && resultCode == RESULT_OK)
                CodesFileStep.e.setText(fullFilePathResult);
             else if (requestCode == 1 && resultCode == RESULT_OK)
                ExamFileStep.e.setText(fullFilePathResult);
        }
    }
}