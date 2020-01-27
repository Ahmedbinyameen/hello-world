package com.example.bluecloudmedicalclinic.Create_Patient;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.db.SQLiteCreateProfileHelper;

public class Create_Profile extends AppCompatActivity implements View.OnClickListener {


//    SQLiteLoginHelper SQLITELOGINDATABASE;
  SQLiteCreateProfileHelper myDb;
     Button submit;
    SQLiteDatabase SQLITEDATABASE;
    String SQLiteQuery;
    EditText GetFirstName, GetLastName, GetDateOfBirth, GetPhoneNumber, GetUserName, GetPassword , GetUserType;
    String First_Name, Last_Name, Date_Of_Birth, Gender, Phone_number, Username, Password, Female, Male, User_Type;
    Boolean CheckEditTextEmpty;
    CheckBox GetFemale, GetMale;
    Cursor y;
    Intent i;


//    ArrayList<String> selection = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__profile);

//       SQLITELOGINDATABASE = new SQLiteLoginHelper(this);

        myDb = new SQLiteCreateProfileHelper(this);

        GetFirstName = (EditText) findViewById(R.id.first_name);

        GetLastName = (EditText) findViewById(R.id.last_name);

        GetDateOfBirth = (EditText) findViewById(R.id.date_of_birth);

//        GetGender = (EditText) findViewById(R.id.check1);

        GetPhoneNumber = (EditText) findViewById(R.id.mobile_number);

        GetUserName = (EditText) findViewById(R.id.username);

        GetPassword = (EditText) findViewById(R.id.et11);

        GetUserType = (EditText) findViewById(R.id.et_user_type);

        GetFemale = (CheckBox) findViewById(R.id.check1);
        GetFemale.setOnClickListener(this);

        GetMale = (CheckBox) findViewById(R.id.check2);
        GetMale.setOnClickListener(this);






        submit = (Button) findViewById(R.id.btn_create_profile);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 DBCreate();

                SubmitDate2SQLiteDB();



            }
//                First_Name = GetFirstName.getText().toString();
//        Last_Name = GetLastName.getText().toString();
//        Date_Of_Birth = GetDateOfBirth.getText().toString();
//        Phone_number = GetPhoneNumber.getText().toString();
//        Username = GetUserName.getText().toString();
//        Password = GetPassword.getText().toString();
//                User_Type = GetUserType.getText().toString();
//
//                if(First_Name.equals("") || Last_Name.equals("") || Date_Of_Birth.equals("") ||
//                        Phone_number.equals("") || Username.equals("") || Password.equals("") || User_Type.equals(""))
//                {
//                    Toast.makeText(Create_Profile.this, "Please Fill in all your Details", Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//
////                    y = SQLITELOGINDATABASE.check_duplicates_in_user_credentials(Username, Password, getResources().getString(R.string.user_credentials));
////
////                     if(y.moveToFirst())
////                    {
////                        Toast.makeText(Create_Profile.this, "User Already Exists", Toast.LENGTH_LONG).show();
////                        Toast.makeText(Create_Profile.this, "Login With Your Username and Password", Toast.LENGTH_LONG).show();
////                    }
////                    else
////                    {
//
//                        boolean b = SQLITELOGINDATABASE.insert_user_credentials(First_Name, Last_Name, Date_Of_Birth, Phone_number, Username, Password, User_Type);
//                        if(b)
//                        {
//                            Bundle bb = new Bundle();
//                            bb.putString("username", Username);
//                            bb.putString("password", Password);
//                            bb.putString("user_type", User_Type);
//
//                            if(User_Type.equals("Dr_Ahmad"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("dr_alex"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//
//                            }
//                            else if(User_Type.equals("Dr_Bliss"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("Dr_Brick"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("Dr_Hunter"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("Dr_Mistry"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("Dr_Rash"))
//                            {
//                                i= new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if (User_Type.equals("Dr_Spot"))
//                            {
//                                i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                            }
//                            else if(User_Type.equals("Patient"))
//                            {
//                                i = new Intent(Create_Profile.this, Book_Appointment.class);
//                            }
//                            else
//                            {
//                                i = new Intent(Create_Profile.this, Book_Appointment.class);
//                            }
//
//                            i.putExtras(bb);
//                            startActivity(i);
//                            finish();
//                        }
//                    }
//
//
//
//
//            }
//        });
//

            });
    }

    public  void DBCreate() {

        SQLITEDATABASE = openOrCreateDatabase("Bluecloud.db", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Create_Patient_Table(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , first_name TEXT, last_name TEXT, date_of_birth VARCHAR,  mobile_no VARCHAR, email VARCHAR, password VARCHAR, user_type VARCHAR, female VARCHAR, male VARCHAR)");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dr__ahmed__tabbed_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Close Clicked ", Toast.LENGTH_LONG).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public  void SubmitDate2SQLiteDB()
    {
        First_Name = GetFirstName.getText().toString();
        Last_Name = GetLastName.getText().toString();
        Date_Of_Birth = GetDateOfBirth.getText().toString();
        Phone_number = GetPhoneNumber.getText().toString();
        Username = GetUserName.getText().toString();
        Password = GetPassword.getText().toString();
        User_Type = GetUserType.getText().toString();

        if(GetFemale.isChecked())
        {
            Female = GetFemale.getText().toString();
        }
        if(GetMale.isChecked())
        {
            Male = GetMale.getText().toString();
        }



//        Male = GetMale.getText().toString();
//        Female = GetFemale.getText().toString();

        CheckEditTextIsEmptyOrNot(First_Name, Last_Name, Date_Of_Birth , Phone_number, Username, Password , User_Type);

        if(CheckEditTextEmpty == true) {
////            try
////            {
////                if (First_Name.equals("") || Last_Name.equals("") || Date_Of_Birth.equals("") ||
////                        Phone_number.equals("") || Username.equals("") || Password.equals("") || User_Type.equals(""))
////                {
////                    Toast.makeText(Create_Profile.this, "Please Fill in all your Details", Toast.LENGTH_LONG).show();
////                }
//                else
//                {

            SQLiteQuery = "INSERT INTO Create_Patient_Table(first_name, last_name, date_of_birth, mobile_no, email, password, user_type, female, male) VALUES('" + First_Name + "','" + Last_Name + "','" + Date_Of_Birth + "','" + Phone_number + "','" + Username + "','" + Password + "', '" + User_Type + "', '"+Female+"', '"+Male+"')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Create_Profile.this, "New Entry Inserted", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
            Intent intent = new Intent( Create_Profile.this, Login.class);
            startActivity(intent);

        }

        else {

            Toast.makeText(this, "Please Fill in all your Details", Toast.LENGTH_LONG).show();
        }


//                    Bundle bb = new Bundle();
//                    bb.putString("username", Username);
//                    bb.putString("password", Password);
//                    bb.putString("user_type", User_Type);
//
//                    if(User_Type.equals("Dr_Ahmad_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Dr_Alex_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//
//                    }
//                    else if(User_Type.equals("Dr_Bliss_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Dr_Brick_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Dr_Hunter_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Dr_Mistry_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Dr_Rash_Tabbed_Activity"))
//                    {
//                        i= new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if (User_Type.equals("Dr_Spot_Tabbed_Activity"))
//                    {
//                        i = new Intent(Create_Profile.this, Patient_Prescription_Form.class);
//                    }
//                    else if(User_Type.equals("Patient"))
//                    {
//                        i = new Intent(Create_Profile.this, Book_Appointment.class);
//                    }
//                    else
//                    {
//                        i = new Intent(Create_Profile.this, Book_Appointment.class);
//                    }
////
//
//                    i.putExtras(bb);

//                    startActivity(i);

                }

//            catch (SQLException e)
//            {
//
//                Toast.makeText(Create_Profile.this, "Registration Failed", Toast.LENGTH_LONG).show();
//            }




//           i = new Intent(Create_Profile.this, Book_Appointment.class);
//            startActivity(intent);






    //
//    public  void AddData()
//    {
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                CheckEditTextIsEmptyOrNot(First_Name, Last_Name, Date_Of_Birth , Phone_number, Email, Password );
//
//               boolean isInserted =  myDb.insertData(GetFirstName.getText().toString(),
//                        GetLastName.getText().toString(),
//                        GetDateOfBirth.getText().toString(),
//                        GetPhoneNumber.getText().toString(),
//                        GetEmail.getText().toString(),
//                        GetPassword.getText().toString());
//
//                if(isInserted == true)
//                {
//
//                    Toast.makeText(Create_Profile.this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
//                    ClearEditTextAfterDoneTask();
//                }
//                else
//                {
//                    Toast.makeText(Create_Profile.this, "Please Fill All The Fields ", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
    public  void  CheckEditTextIsEmptyOrNot(String First_Name, String Last_Name, String Date_Of_Birth, String Phone_number, String Username, String Password, String user_Type)
    {
        CheckEditTextEmpty = !(TextUtils.isEmpty(First_Name) || TextUtils.isEmpty(Last_Name) || TextUtils.isEmpty(Date_Of_Birth) || TextUtils.isEmpty(Phone_number) || TextUtils.isEmpty(Username) || TextUtils.isEmpty(Password) || TextUtils.isEmpty(user_Type));
    }

    public void ClearEditTextAfterDoneTask()
    {
        GetFirstName.getText().clear();
        GetLastName.getText().clear();
        GetDateOfBirth.getText().clear();
//        GetGender.getText().clear();
        GetPhoneNumber.getText().clear();
        GetUserName.getText().clear();
        GetPassword.getText().clear();
        GetUserType.getText().clear();

    }


   /* public  void selectItem(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.check1:
                if(checked)
                {
                    selection.add("Female");

                }
                else
                {
                    selection.remove("Female");
                }
            case R.id.check2:
                if(checked)
                {
                    selection.add("Male");

                }
                else
                {
                    selection.remove("Male");
                }
                break;
        }
    }*/


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.check1:
                if(GetFemale.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Female Clicked", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.check2:
                if(GetMale.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Male Clicked", Toast.LENGTH_LONG).show();
                }

        }
    }

}
