package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by HP on 1/6/2020.
 */

public class ExternalStorageUtil {

    public static boolean isExternalStorageMounted()
    {
        String dirState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(dirState);
    }

//    Get Private External Storage
    public static  String getPrivateExternalStorageBaseDir(Context context, String  dirType)
    {
        String  ret = "";
        if(isExternalStorageMounted())
        {
            File file = context.getExternalFilesDir(dirType);
            ret = file.getAbsolutePath();
        }
        return  ret;
    }
}
