package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Finish_Pay;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.Login.View_Profile;
import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call.HD_Vid_Call;
import com.example.bluecloudmedicalclinic.db.SQLiteCreateProfileHelper;
import com.example.bluecloudmedicalclinic.db.SQLitePatientPaymentHelper;


public class Patient_PDF_File_Download extends AppCompatActivity {

    Button getDownloadPDF, cancel;
    SQLitePatientPaymentHelper myDB;
    SQLiteCreateProfileHelper myCreatePorfileDB;
    SQLiteDatabase SQLiteDatebase, SQLiteDatabase2;
    Button gotoDownload;
    Cursor cursor;
 AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__pdf__file_download);

        builder = new AlertDialog.Builder(this);

        myDB = new SQLitePatientPaymentHelper(this);

        myCreatePorfileDB = new SQLiteCreateProfileHelper(this);



        cancel = (Button) findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


       getDownloadPDF = (Button) findViewById(R.id.btn_download);
        getDownloadPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patient_PDF_File_Download.this, Patient_Payment_Form_Download_pdf.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.Logout:

                builder.setMessage(R.string.dialog_msg).setTitle(R.string.title);
                builder.setMessage("Do you want to Logout ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent in = new Intent(getApplicationContext(), Login.class);
                                startActivity(in);
                                Toast.makeText(getApplicationContext(), "Logout...", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Okay...", Toast.LENGTH_LONG).show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("BlueCloud Medical Application");
                alertDialog.show();
//                Toast.makeText(getApplicationContext(), "LogOut Clicked", Toast.LENGTH_LONG).show();
//                Intent intent1 = new Intent(Patient_PDF_File_Download.this, Login.class);
//                startActivity(intent1);
//                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
