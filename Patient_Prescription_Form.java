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
import com.example.bluecloudmedicalclinic.db.SQLitePrescriptionHelper;


public class Patient_Prescription_Form extends AppCompatActivity implements  View.OnClickListener{

    SQLitePrescriptionHelper myPrescription;
    EditText GetMedication, GetDosage, GetInstruction;
    Button Save, Cancel;
    SQLiteDatabase SQLITEDATABASE;
    String SQLiteQuery;
    String Medication, Dosage, Instruction, Prescription;
    Boolean CheckEditTextEmpty;
    CheckBox GetPrescription;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__prescription__form);

        builder = new AlertDialog.Builder(this);

        myPrescription = new SQLitePrescriptionHelper(this);

        GetMedication = (EditText) findViewById(R.id.medication);

        GetDosage = (EditText) findViewById(R.id.medication1);

        GetInstruction = (EditText) findViewById(R.id.instruction);

        Save = (Button) findViewById(R.id.dose_save);

        Cancel = (Button) findViewById(R.id.dose_cancel);

        GetPrescription= (CheckBox) findViewById(R.id.checkbox1);
        GetPrescription.setOnClickListener(this);


        if (GetPrescription.isChecked())
        {
            Prescription= GetPrescription.getText().toString();
        }


//        if (GetPrescription.isChecked())
//        {
//            Prescription = GetPrescription.getText().toString();
//        }


        Save.setOnClickListener(new View.OnClickListener() {
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




//        Spinner spinner = (Spinner) findViewById(R.id.dose_spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Select_Dose_Name, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
    }

    public  void DBCreate() {
        SQLITEDATABASE = openOrCreateDatabase("Bluecloud.db", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS New_Prescription_Table(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, medication TEXT, dosage VARCHAR, instruction VARCHAR, prescription VARCHAR);");
    }

    public  void SubmitDate2SQLiteDB()
    {
        Medication = GetMedication.getText().toString();
        Dosage = GetDosage.getText().toString();
        Instruction = GetInstruction.getText().toString();

//        Prescription = GetPrescription.getText().toString();


        CheckEditTextIsEmptyOrNot(Medication, Dosage, Instruction);

        if(GetPrescription.isChecked())
        {
            SQLiteQuery = "INSERT INTO New_Prescription_Table(medication, dosage, instruction) VALUES('"+Medication+"','"+Dosage+"','"+Instruction+"')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Patient_Prescription_Form.this, "You'r Data is Saved Successfully", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
            Intent intent = new Intent(Patient_Prescription_Form.this, Patient_Payment_Form.class);
            startActivity(intent);
        }


       else if(CheckEditTextEmpty==true)
        {
            SQLiteQuery = "INSERT INTO New_Prescription_Table(medication, dosage, instruction, prescription) VALUES('"+Medication+"','"+Dosage+"','"+Instruction+"', '"+Prescription+"')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Patient_Prescription_Form.this, "You'r Data is Saved Successfully", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
            Intent intent = new Intent(Patient_Prescription_Form.this, Patient_Payment_Form.class);
            startActivity(intent);


        }


        else
        {
            Toast.makeText(Patient_Prescription_Form.this, "Please fill the Patient Prescription, Thanks.", Toast.LENGTH_LONG).show();
        }
    }


    public  void  CheckEditTextIsEmptyOrNot(String Medication, String Dosage, String Instruction)
    {
        CheckEditTextEmpty = !(TextUtils.isEmpty(Medication) || TextUtils.isEmpty(Dosage) || TextUtils.isEmpty(Instruction));
    }

    public void ClearEditTextAfterDoneTask()
    {
       GetMedication.getText().clear();
        GetDosage.getText().clear();
        GetInstruction.getText().clear();
        GetPrescription.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
       {
           case R.id.checkbox1:
               if(GetPrescription.isChecked())
               {
                   Toast.makeText(getApplicationContext(), "Non-Prescription Clicked",Toast.LENGTH_LONG).show();
                   GetMedication.setEnabled(false);
                   GetDosage.setEnabled(false);
                   GetInstruction.setEnabled(false);
               }
               else
               {
                   GetMedication.setEnabled(true);
                   GetDosage.setEnabled(true);
                   GetInstruction.setEnabled(true);

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



//    @Override
//    public void onClick(View v) {
//       switch (v.getId())
//       {
//           case R.id.checkbox1:
//               if(GetPrescription.isChecked())
//               {
//                   Toast.makeText(getApplicationContext(), "Non-Prescription Clicked",Toast.LENGTH_LONG).show();
//               }
//               break;
//       }
//    }


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//
//        if(parent.getItemAtPosition(position).equals("Select_Dose_Name"))
//        {
//
//        }
//        else
//        {
//            if(parent.getItemAtPosition(position).equals("Regix"))
//            {
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//            else if(parent.getItemAtPosition(position).equals("Concor 5mg"))
//            {
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//            else if(parent.getItemAtPosition(position).equals("Lipiget 10mg"))
//            {  Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//
//            }
//            else if(parent.getItemAtPosition(position).equals("Ponston"))
//            {
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//            else if(parent.getItemAtPosition(position).equals("Disprine"))
//            {
//
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//            else if(parent.getItemAtPosition(position).equals("Asprin"))
//            {
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//            else if(parent.getItemAtPosition(position).equals("Janumet 500/1000mg"))
//            {
//                Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();
//            }
//
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
