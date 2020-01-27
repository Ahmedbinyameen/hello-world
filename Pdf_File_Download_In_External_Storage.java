package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.os.Environment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Pdf_File_Download_In_External_Storage extends AppCompatActivity {
    EditText inputText;
    TextView response;
    Button saveButton, readButton;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    private  String fileName = "Patient_Payment_Form.pdf";
    private String filePath = "PDF";
    String  content = "PDF File";
    File file;
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf__file__download__in__external__storage);

        inputText = (EditText) findViewById(R.id.myInputText);
        response = (TextView) findViewById(R.id.response);


        saveButton =
                (Button) findViewById(R.id.saveExternalStorage);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = "Patient_Payment_Form.pdf";
                try {

                    file = new File(Environment.getExternalStorageDirectory(),"PDF_FILE.pdf");
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(content.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Toast.makeText(getApplicationContext(), "File Saved..." + file, Toast.LENGTH_LONG).show();
//                inputText.setText("");
//                response.setText("SampleFile.txt saved to External Storage...");
            }
        });


        readButton = (Button) findViewById(R.id.getExternalStorage);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputText.setText(myData);
                response.setText("SampleFile.txt data retrieved from External Storage...");
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
        } else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


    }


    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);


    }
}
