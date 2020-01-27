package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.bluecloudmedicalclinic.Finish_Pay;
import com.example.bluecloudmedicalclinic.List_View.List_View;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.Login.View_Profile;
import com.example.bluecloudmedicalclinic.R;
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
import com.itextpdf.text.pdf.codec.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;


public class Patient_Payment_Receipt_PDF extends AppCompatActivity {

    SQLitePatientPaymentHelper myDB;
    SQLitePatientPaymentHelper myPatientPaymentHelper;
    EditText showInPdf;
    SQLiteDatabase SQLiteDatebase;
    Button ShowData, CreatePDF, Cancel;
    String Query;
    SQLiteDatabase SQLiteDatabase;
    Cursor cursor;
    Timer timer;
    EditText GetUsername;
    String username;
    private static int SPLASH_TIME_OUT = 8000;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pateint__payment__receipt__pdf);


        builder = new AlertDialog.Builder(this);

        ActivityCompat.requestPermissions(Patient_Payment_Receipt_PDF.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        myDB = new SQLitePatientPaymentHelper(this);

        GetUsername = (EditText) findViewById(R.id.patient_id);
        username = GetUsername.getText().toString();

//        showInPdf = (EditText) findViewById(R.id.pdf_file);


//        myPatientPaymentHelper = new SQLitePatientPaymentHelper(this);
//
//
//
//        CreatePDF = (Button) findViewById(R.id.btn_download);
//       CreatePDF.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onClick(View v) {
////                Intent show_data = new Intent(getApplicationContext(), Patient_Payment_Form_Download_pdf.class);
////                startActivity(show_data);
//                createPDF();
//
//
//            }
//
//       });

        CreatePDF = (Button) findViewById(R.id.btn_create_pdf);
        CreatePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetUsername.setEnabled(true);
                username = GetUsername.getText().toString();

                if(username.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Enter a username", Toast.LENGTH_LONG).show();
                }
                else {


                    String fileName = "Patient_Payment_Form";
                    String File = Environment.getExternalStorageDirectory().toString() + "/ PDF /" + username + ".pdf";
                    Document document = new Document(PageSize.A4);
                    String root = Environment.getExternalStorageDirectory().toString();
                    java.io.File myDir = new File(root + "/PDF");
                    myDir.mkdirs();
//        Create PDF Writer for writting into New Created Document:
//                File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString(), fileName + ".pdf" );
                    try {

                        PdfWriter.getInstance(document, new FileOutputStream(File));
                        document.open();
                        addMetaData(document);
                        addPageTitle(document);

//            addData(document);
//            addImage(document);


                    } catch (FileNotFoundException | DocumentException e) {
                        e.printStackTrace();
                    }

                    document.close();

                    Toast.makeText(Patient_Payment_Receipt_PDF.this, "Your PDF File is generated, Thanks", Toast.LENGTH_LONG).show();

                    Toast.makeText(Patient_Payment_Receipt_PDF.this, " Pdf File Location : " + File,
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Patient_Payment_Receipt_PDF.this, Patient_Payment_Form_Download_pdf.class);
                    startActivity(intent);
                }
            }
        });

        ShowData = (Button) findViewById(R.id.btn_show_data);
        ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Payment_Receipt_PDF.this, List_View.class);
                startActivity(intent);

//                timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//
//                        finish();
//
//                    }
//
//                },SPLASH_TIME_OUT);

//                Intent show_data = new Intent(getApplicationContext(), List_View.class);
//                startActivity(show_data);
            }
        });


        Cancel = (Button) findViewById(R.id.btn_cancel);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

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

//        Start New Paragraph

//        Paragraph p = new Paragraph();
//        Image i ;
////        int indentation = 0;
////        float scaler;
//        try {
//            i = Image.getInstance("resources/drawable/logo.PNG");
//
////            scaler = ((document.getPageSize().getWidth() - document.leftMargin() -
////            document.rightMargin() - indentation ) / i.getWidth()) * 100;
////            i.scalePercent(scaler);
//            p.add(i);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        For Image:
//
//        document.add(p);
//        document.add(myTable);
//        document.add(myTable);

//        Image
//        Image image = null;
//        String imgPath = "resources/drawable/logo.PNG";
//        try {
//            image = Image.getInstance(imgPath);
//            image.scaleToFit(100f, 200f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        document.add(image);


//        Chunk c = new Chunk("Hello:");
//        prHead.add(c);
//        Image image;
//        try {
//            image = Image.getInstance("resources/drawable/logo.PNG");
//            c= new Chunk(image, 0, 10);
//            prHead.add(c);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Create Table into Document with 1 Row

        PdfPTable myTable = new PdfPTable(1);
        myTable.setWidthPercentage(100.0f);

        Paragraph prHead = new Paragraph();
        prHead.setFont(title);
        prHead.add(" BlueCloud Medical Clinic Hospital \n ");
        prHead.setAlignment(Element.ALIGN_CENTER);


//        Create New Cell into Table

//        PdfPCell myCell = new PdfPCell(new Paragraph(""));
//        myCell.setBorder(Rectangle.BOTTOM);
//        myCell.setVerticalAlignment(Rectangle.LEFT);
////        Add cell into Table
//        myTable.addCell(myCell);

//        For Heading:
        document.add(prHead);
        document.add(myTable);
        document.add(myTable);


        Paragraph patientTitle = new Paragraph();
        patientTitle.setFont(catFont);
        patientTitle.add("Patient Payment Form");
        patientTitle.setAlignment(Element.ALIGN_CENTER);


//        Add all above details into Document:

        document.add(patientTitle);
        document.add(myTable);
        document.add(myTable);


//        if (username.equals(""))
//        {
//            Toast.makeText(getApplicationContext(), "Kindly fill the username.", Toast.LENGTH_LONG).show();
//        }
//
//        else if(myDB.CheckUser(username))
////        {
//        if(username.equals(""))
//        {
//            Toast.makeText(getApplicationContext(), "Enter a username, Thanks", Toast.LENGTH_LONG).show();
//        }
//        else {


//        String SQLITEQUERY;
//        SQLITEQUERY = "SELECT first_name, last_name, zip, location, amount, card_number, card_expiry_date, card_holder_name, email FROM  New_Patient_Table  ";

//        cursor = SQLiteDatebase.rawQuery(" SELECT first_name, last_name, zip, location, amount, card_number, card_expiry_date, card_holder_name, email FROM  New_Patient_Table WHERE email = '"+username+"' ",  null );
//

//


//
//       PDF


        Paragraph p = new Paragraph();
        p.setFont(normal);
        p.add("\n \n ");

//

//        if(myDB.createPDF(username))
//        {
//            myTable.addCell("Patient First Name:");
//            myTable.addCell("\n");
//            myTable.addCell("Last Name:");
//            myTable.addCell("\n");
//            myTable.addCell("Zip:");
//            myTable.addCell("\n");
//            myTable.addCell("Location:");
//            myTable.addCell("\n");
//            myTable.addCell("Amount:");
//            myTable.addCell("\n");
//            myTable.addCell("Card:");
//            myTable.addCell("\n");
//            myTable.addCell("Card Expiry:");
//            myTable.addCell("\n");
//            myTable.addCell("Card Holder Name:");
//            myTable.addCell("\n");
//            myTable.addCell("Email:");
//            myTable.addCell("\n");
//        }

//        cursor = myDB.check_duplicates_in_user_credentials(username, getResources().getString(R.string.user_credentials));

//
//
//        if(myDB.createPDF(username))
//        {

//        SQLiteDatebase = myDB.getReadableDatabase();
//        cursor = SQLiteDatebase.rawQuery("SELECT first_name, last_name, zip, location, amount, card_number, card_expiry_date, card_holder_name, email FROM New_Patient_Table " ,null);

//        cursor = myDB.search(username);

        cursor = myDB.getData(GetUsername.getText().toString());

        if (cursor.getCount()>0 ) {

            if (cursor.moveToFirst()) {


                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
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
//            while (cursor.moveToNext());


//        Othervise this code is correct:::

//        int count = cursor.getCount();
////        for (int j = 0; j < count; j++) {
//
//            myTable.addCell(" Patient First Name : " + "      " + cursor.getString(cursor.getColumnIndex("first_name")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("first_name")));
//            myTable.addCell("\n");
//            myTable.addCell(" Patient Last Name : " + "      " + cursor.getString(cursor.getColumnIndex("last_name")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("last_name")));
//            myTable.addCell("\n");
//            myTable.addCell("Zip Code : " + "      " + cursor.getString(cursor.getColumnIndex("zip")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("zip")));
//            myTable.addCell("\n");
//            myTable.addCell("Location : " + "      " + cursor.getString(cursor.getColumnIndex("location")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("location")));
//            myTable.addCell("\n");
//            myTable.addCell("Amount : " + "      " + cursor.getString(cursor.getColumnIndex("amount")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("amount")));
//            myTable.addCell("\n");
//            myTable.addCell("Card Number : " + "      " + cursor.getString(cursor.getColumnIndex("card_number")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_number")));
//            myTable.addCell("\n");
//            myTable.addCell("Card Expiry Date : " + "      " + cursor.getString(cursor.getColumnIndex("card_expiry_date")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_expiry_date")));
//            myTable.addCell("\n");
//            myTable.addCell("Card Holder Name : " + "      " + cursor.getString(cursor.getColumnIndex("card_holder_name")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("card_holder_name")));
//            myTable.addCell("\n");
//            myTable.addCell("Patient Email Address : " + "      " + cursor.getString(cursor.getColumnIndex("email")));
////            myTable.addCell(cursor.getString(cursor.getColumnIndex("email")));
//
//
//            cursor.moveToNext();


//        Now Start Another New Paragraph
//        Paragraph patientinfo = new Paragraph();
//        patientinfo.setFont(smallBold);
//        patientinfo.add("\n");
//        patientinfo.add("\n");
//        patientinfo.add("\n");
//        patientinfo.add("\n");
//        patientinfo.add("Patient First Name:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Patient Last Name:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Zip:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Location\n");
//        patientinfo.add("\n");
//        patientinfo.add("Amount:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Card Number:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Expiry Date:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Card Holder Name:\n");
//        patientinfo.add("\n");
//        patientinfo.add("Email Address:\n");
//        patientinfo.add("\n");
//
//        patientinfo.setAlignment(Element.ALIGN_LEFT);
//
//        document.add(patientinfo);
//        document.add(myTable);
//        document.add(myTable);
//
////        document.newPage();
//
//
//        cursor.close();

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
}




