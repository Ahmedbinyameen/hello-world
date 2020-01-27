package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.Manifest;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.bluecloudmedicalclinic.Finish_Pay;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.Login.View_Profile;
import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call.Video_Call;
import com.example.bluecloudmedicalclinic.db.SQLitePatientPaymentHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

import static com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.ExternalStorageUtil.getPrivateExternalStorageBaseDir;


public class Patient_Payment_Form_Download_pdf extends AppCompatActivity {

    SQLitePatientPaymentHelper myDB;
    Button downloadPDF, viewPDF;
    Cursor cursor;
    EditText GetUsername;
    String username;
    AlertDialog.Builder builder;
    String fileName = "Patient_Payment_Form.pdf";
    Timer timer;

    ProgressBar progressBar;

    private final int EXTERNAL_STORAGE_PERMISSION_CODE = 69;
    private static  int SPLASH_TIME_OUT = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Patient_Payment_Form_Download_pdf.this, Video_Call.class);
//                startActivity(intent);
//            }
//
//        }, SPLASH_TIME_OUT);

        setContentView(R.layout.activity_patient__payment__form__download_pdf);

        myDB = new SQLitePatientPaymentHelper(this);

        ActivityCompat.requestPermissions(Patient_Payment_Form_Download_pdf.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        GetUsername = (EditText) findViewById(R.id.patient_id);
        username = GetUsername.getText().toString();

        GetUsername.setEnabled(false);

        builder = new AlertDialog.Builder(this);
        viewPDF = (Button) findViewById(R.id.openDownloadedFolder);
        viewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetUsername.setEnabled(true);
                username = GetUsername.getText().toString();

                if (username.equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter a username", Toast.LENGTH_LONG).show();

                }
                else {


                    builder.setMessage(R.string.dialog_msg).setTitle(R.string.title);
                    builder.setMessage("Do you want to View this PDF File ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

//                                pdfFileView();
                                    viewPDF();

//                                Toast.makeText(getApplicationContext(), "Patient Payment Form Pdf...", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent(getApplicationContext(), Patient_Payment_Receipt_PDF.class);
//                                startActivity(intent);
                                    Toast.makeText(getApplicationContext(), "Okay...", Toast.LENGTH_LONG).show();
                                }
                            });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.setTitle("BlueCloud Medical Application");
                    alertDialog.show();
                }
//                View();
            }
        });


        downloadPDF = (Button) findViewById(R.id.downloadPdf);
        downloadPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetUsername.setEnabled(true);
                username = GetUsername.getText().toString();

                if (username.equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter a username", Toast.LENGTH_LONG).show();

                }
                else
                {

                    builder.setMessage(R.string.dialog_msg).setTitle(R.string.title).setIcon(R.drawable.ic_warning_black_24dp);
                    builder.setMessage("Do you want to download this PDF File ?")
//                        .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

//                                    Toast.makeText(getApplicationContext(), "Please enter a username.", Toast.LENGTH_LONG).show();


//                                    String File = Environment.getExternalStorageDirectory().toString() + "/ Downloads /" + username + ".pdf";
//                                    Document document = new Document(PageSize.A4);
//                                    String root = Environment.getExternalStorageDirectory().toString();
//                                    java.io.File myDir = new File(root + "/Downloads");
//                                    myDir.mkdirs();
                                    String File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + " " + username + ".pdf";
                                    Document document = new Document(PageSize.A4);

//                                    String File = Environment.getExternalStorageDirectory().toString() + " / DownloadPdf / " + username + ".pdf";
////                                String File = Environment.getExternalStorageDirectory().toString() + "/PDF/" + "Patient_Payment_Form.pdf";
//                                    Document document = new Document(PageSize.A4);
//                                String root = Environment.getExternalStorageDirectory().toString();
//                                java.io.File myDir = new File(root + "/DownloadPdf");
//                                myDir.mkdirs();

                                    try {

                                        PdfWriter.getInstance(document, new FileOutputStream(File));
                                        document.open();
                                        addMetaData(document);
                                        addPageTitle(document);

                                    } catch (FileNotFoundException | DocumentException e) {
                                        e.printStackTrace();
                                    }

                                    document.close();

                                    Toast.makeText(Patient_Payment_Form_Download_pdf.this, "Downloading...", Toast.LENGTH_LONG).show();

                                    Toast.makeText(Patient_Payment_Form_Download_pdf.this, " Pdf File Location : " + File ,
                                            Toast.LENGTH_LONG).show();

                                    Toast.makeText(Patient_Payment_Form_Download_pdf.this, "Saved...", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(Patient_Payment_Form_Download_pdf.this, Video_Call.class);
                                    startActivity(intent);
                                }




                            })



                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent(getApplicationContext(), Patient_Payment_Receipt_PDF.class);
//                                startActivity(intent);
                                    Toast.makeText(getApplicationContext(), "Okay...", Toast.LENGTH_LONG).show();
                                }
                            });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.setTitle("BlueCloud Medical Application");

//                    alertDialog.setIcon(R.drawable.logo);
                    alertDialog.show();
                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"Try Again", Toast.LENGTH_LONG).show();
//                }

//               downloadPdf();

//                setContentView(tv_loading);
//                tv_loading.setGravity(Gravity.CENTER);
//                tv_loading.setTypeface(null, Typeface.BOLD);

            }
        });
    }


    public void addMetaData(Document document) {
        document.addTitle("BlueCloud Medical Clinic Hospital");
        document.addSubject("Patient Payment Form");
        document.addKeywords("Personal, location, email ");
        document.addAuthor("TAG");
        document.addCreator("TAG");

    }


    public void addPageTitle(Document document) throws DocumentException {


//         Font Style For Document:
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
        Font title = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD | Font.UNDERLINE, BaseColor.GRAY);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

        PdfPTable myTable = new PdfPTable(1);
        myTable.setWidthPercentage(100.0f);

        Paragraph prHead = new Paragraph();
        prHead.setFont(title);
        prHead.add(" BlueCloud Medical Clinic Hospital \n ");
        prHead.setAlignment(Element.ALIGN_CENTER);


        document.add(prHead);
        document.add(myTable);
        document.add(myTable);

        Paragraph patientTitle = new Paragraph();
        patientTitle.setFont(catFont);
        patientTitle.add("Patient Payment Form");
        patientTitle.setAlignment(Element.ALIGN_CENTER);


        document.add(patientTitle);
        document.add(myTable);
        document.add(myTable);

        Paragraph p = new Paragraph();
        p.setFont(normal);
        p.add("\n \n ");

        cursor = myDB.getData(GetUsername.getText().toString());

        if (cursor.getCount()>0 ) {

            if (cursor.moveToFirst()) {


                Toast.makeText(getApplicationContext(), "Hello...", Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_LONG).show();
                do {

                    myTable.addCell("Patient First Name : " + "      " + cursor.getString(cursor.getColumnIndex("first_name")));
////////            myTable.addCell(cursor.getString(cursor.getColumnIndex("first_name")));
                    myTable.addCell("\n");
                    myTable.addCell("Patient Last Name : " + "      " + cursor.getString(cursor.getColumnIndex("last_name")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("last_name")));
                    myTable.addCell("\n");
                    myTable.addCell("Zip Code : " + "      " + cursor.getString(cursor.getColumnIndex("zip")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("zip")));
                    myTable.addCell("\n");
                    myTable.addCell("Location/Address : " + "      " + cursor.getString(cursor.getColumnIndex("location")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("location")));
                    myTable.addCell("\n");
                    myTable.addCell("Total Amount : " + "      " + cursor.getString(cursor.getColumnIndex("amount")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("amount")));
                    myTable.addCell("\n");
                    myTable.addCell("Card Number : " + "      " + cursor.getString(cursor.getColumnIndex("card_number")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_number")));
                    myTable.addCell("\n");
                    myTable.addCell("Card Expiry Date : " + "      " + cursor.getString(cursor.getColumnIndex("card_expiry_date")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_expiry_date")));
                    myTable.addCell("\n");
                    myTable.addCell("Card Holder Name : " + "      " + cursor.getString(cursor.getColumnIndex("card_holder_name")));
//////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_holder_name")));
                    myTable.addCell("\n");
                    myTable.addCell("Patient Email Address : " + "      " + cursor.getString(cursor.getColumnIndex("email")));
                    myTable.addCell("\n");
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("email")));

                }

                while (cursor.moveToNext());

            } else {
                Toast.makeText(getApplicationContext(), "No Data Found.", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Complete you'r all Dues.", Toast.LENGTH_LONG).show();

                cursor.close();
            }

        }

        document.add(p);
        document.add(myTable);
        document.addCreationDate();


        document.newPage();


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

                AlertDialog alert = builder.create();
                alert.setTitle("BlueCloud Medical Application");
                alert.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void  viewPDF()
    {

        Uri path;
        File pdfFile = new File(Environment.getExternalStorageDirectory()+ "/"
         + "Download" + " / " + username + ".pdf");

//        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + username + ".pdf";
//        File file = new File(path);
//
//        if(Build.VERSION.SDK_INT >= 24)
//        {
//            path = FileProvider.getUriForFile(getApplicationContext(), "BlueCloud Medical Clinic", pdfFile);
//        }
//        else
//        {
//            path = Uri.fromFile(pdfFile);
//        }

        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(pdfFile), "application/pdf");
//        target.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_GRANT_READ_URI_PERMISSION);

//        if(target.resolveActivity(getPackageManager()) == null)
//        {
//            Toast.makeText(getApplicationContext(), "Can't read pdf file" , Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            startActivity(target);
//        }
        Intent intent = Intent.createChooser(target, "Open File");

        try {
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {

            Toast.makeText(getApplicationContext(), "Can't read pdf file" +  e.getMessage(), Toast.LENGTH_SHORT).show();
//            no comments.
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == EXTERNAL_STORAGE_PERMISSION_CODE)
        {
            if(!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED))
            {
                Toast.makeText(getApplicationContext(), "This Pdf file requires external storage permission", Toast.LENGTH_LONG).show();
            }
            else
            {
                finish();
            }
        }
    }
}
