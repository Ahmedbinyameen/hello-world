package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Finish_Pay;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.Login.View_Profile;
import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.db.SQLitePatientPaymentHelper;


public class Patient_Payment_Form extends AppCompatActivity implements  View.OnClickListener{

    SQLitePatientPaymentHelper myPatientPayment;
    Button Submit, Cancel;
    SQLiteDatabase SQLITEDATABASE;
    String SQLiteQuery;
    EditText GetID, GetFirstName, GetLastName, GetZip, GetLocation, GetAmount, GetCardNumber, GetCardExp, GetCardHolderName, GetEmail;
    String ID;
    String FirstName;
    String LastName;
    String Zip;
    String Location;
    String Amount;
    String CardNumber;
    String CardExp;
    String CardHolderName;
    String Email;
    String Card;
    String Cash;
    String Check;
    Boolean checkEditTextEmpty;
    CheckBox GetCard, GetCheck, GetCash;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pateint__payment__form);

        builder = new AlertDialog.Builder(this);

        myPatientPayment = new SQLitePatientPaymentHelper(this);

//        GetID = (EditText) findViewById(R.id.patient_id);

        GetFirstName = (EditText) findViewById(R.id.patient_name);

        GetLastName = (EditText) findViewById(R.id.patient_last_name);

        GetZip = (EditText) findViewById(R.id.patient_zip);

        GetLocation = (EditText) findViewById(R.id.patient_location);

        GetAmount = (EditText) findViewById(R.id.patient_amount);

        GetCardNumber = (EditText) findViewById(R.id.patient_card_number);
        GetCardNumber.setEnabled(false);

        GetCardExp = (EditText) findViewById(R.id.patient_card_exp);
        GetCardExp.setEnabled(false);

        GetCardHolderName = (EditText) findViewById(R.id.patient_card_holder);
        GetCardHolderName.setEnabled(false);

        GetEmail = (EditText) findViewById(R.id.patient_email_address);

        GetCard = (CheckBox) findViewById(R.id.patient_card);
        GetCard.setOnClickListener(this);

        GetCheck = (CheckBox) findViewById(R.id.patient_check);
        GetCheck.setOnClickListener(this);

        GetCash = (CheckBox) findViewById(R.id.patient_cash);
        GetCash.setOnClickListener(this);



        Submit = (Button) findViewById(R.id.btn_submit);

        Cancel = (Button) findViewById(R.id.btn_cancel);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBCreate();

                SubmitDate2SQLiteDB();

            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public  void DBCreate() {
        SQLITEDATABASE = openOrCreateDatabase("Bluecloud.db", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS New_Patient_Table (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, first_name TEXT, last_name TEXT, zip VARCHAR, location VARCHAR, amount VARCHAR, card_number VARCHAR, card_expiry_date VARCHAR, card_holder_name VARCHAR, email VARCHAR)");
//        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS New_Patient_Payment_Table(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, first_name TEXT, last_name TEXT, zip VARCHAR,  location VARCHAR, amount VARCHAR, card_number VARCHAR, card_expiry_date VARCHAR, card_holder_name VARCHAR, email VARCHAR, card VARCHAR, check VARCHAR, cash VARCHAR);");
    }

    public  void SubmitDate2SQLiteDB()
    {

        FirstName = GetFirstName.getText().toString();
        LastName = GetLastName.getText().toString();
        Zip = GetZip.getText().toString();
        Location = GetLocation.getText().toString();
        Amount = GetAmount.getText().toString();
        CardNumber = GetCardNumber.getText().toString();
        CardExp = GetCardExp.getText().toString();
        CardHolderName = GetCardHolderName.getText().toString();
        Email = GetEmail.getText().toString();

//        if (GetCard.isChecked())
//        {
//            Card = GetCard.getText().toString();
//        }
//        if (GetCheck.isChecked())
//        {
//            Check = GetCheck.getText().toString();
//        }
//        if (GetCash.isChecked())
//        {
//            Cash = GetCash.getText().toString();
//        }



     this.CheckEditTextIsEmptyOrNot( FirstName,LastName,Zip, Location, Amount, Email);

        if (GetCard.isChecked())
        {
            SQLiteQuery = "INSERT INTO New_Patient_Table ( first_name, last_name, zip, location, card_number, card_expiry_date, card_holder_name, email) VALUES('"+FirstName+"','"+LastName+"','"+Zip+"','"+Location+"','"+CardNumber+"','"+CardExp+"','"+CardHolderName+"','"+Email+"')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Patient_Payment_Form.this,  " Patient Receipt Added ", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
            Intent intent = new Intent(Patient_Payment_Form.this, Patient_Payment_Receipt_PDF.class);
            startActivity(intent);
        }

        else if(checkEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO New_Patient_Table ( first_name, last_name, zip, location, amount, email) VALUES('"+FirstName+"','"+LastName+"','"+Zip+"','"+Location+"','"+Amount+"','"+Email+"')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Patient_Payment_Form.this,  " Patient Receipt Added ", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
            Intent intent = new Intent(Patient_Payment_Form.this, Patient_Payment_Receipt_PDF.class);
            startActivity(intent);

        }



        else
        {
            Toast.makeText(Patient_Payment_Form.this, "Please fill all Patient Details, Thanks. ", Toast.LENGTH_LONG).show();
        }
    }

    public  void  CheckEditTextIsEmptyOrNot( String FirstName, String LastName, String Zip, String Location, String Amount,  String Email)
    {
        this.checkEditTextEmpty = !(TextUtils.isEmpty(FirstName) || TextUtils.isEmpty(LastName) || TextUtils.isEmpty(Zip) || TextUtils.isEmpty(Location) || TextUtils.isEmpty(Amount) || TextUtils.isEmpty(Email));
    }

    public void ClearEditTextAfterDoneTask()
    {
//        GetID.getText().clear();
        GetFirstName.getText().clear();
        GetLastName.getText().clear();
       GetZip.getText().clear();
        GetLocation.getText().clear();
        GetAmount.getText().clear();
        GetCardNumber.getText().clear();
        GetCardExp.getText().clear();
        GetCardHolderName.getText().clear();
        GetEmail.getText().clear();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.patient_card:
                if(GetCard.isChecked())
                {


                    Toast.makeText(getApplication(), "Card Clicked", Toast.LENGTH_LONG).show();
                    GetCardNumber.setEnabled(true);
                    GetCardNumber.setFocusable(true);
                    GetCardExp.setEnabled(true);
                    GetCardExp.setFocusable(true);
                    GetCardHolderName.setEnabled(true);
                    GetCardHolderName.setFocusable(true);
                    GetAmount.setEnabled(false);

                }

                else
                {
                     GetAmount.setEnabled(true);
                    GetCardNumber.setEnabled(false);
                    GetCardExp.setEnabled(false);
                    GetCardHolderName.setEnabled(false);
                }

                break;
            case R.id.patient_check:
                if(GetCheck.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Check Clicked", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.patient_cash:
                if(GetCash.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Cash Clicked", Toast.LENGTH_LONG).show();
                }
                break;
        }
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
