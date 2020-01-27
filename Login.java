package com.example.bluecloudmedicalclinic.Login;



import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Create_Patient.Book_Appointment;
import com.example.bluecloudmedicalclinic.Create_Patient.Create_Profile;
import com.example.bluecloudmedicalclinic.MainActivity;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_PDF_File_Download;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Payment_Form_Download_pdf;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Payment_Receipt_PDF;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Prescription_Form;
import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call.Video_Call;
import com.example.bluecloudmedicalclinic.db.SQLiteCreateProfileHelper;
import com.example.bluecloudmedicalclinic.db.SQLiteLoginHelper;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SQLiteCreateProfileHelper myDBGETFROMCREATEPROFILE;
    SQLiteLoginHelper myLoginDb;
    Button login, save, Signup;
    SQLiteDatabase SQLITEDATABASE;
    String SQLiteQuery;
    EditText GetUsername, GetPassword;
    String username, password, GetSQLiteQuery, user_type;
    Cursor cursor;
    Intent i;
    Boolean CheckEditTextEmpty;
    Spinner Get_user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDBGETFROMCREATEPROFILE = new SQLiteCreateProfileHelper(this);
        myLoginDb = new SQLiteLoginHelper(this);

//        Defining The Values

        login =  findViewById(R.id.login);

        save =  findViewById(R.id.data_save);

        Signup =  findViewById(R.id.signup);

        GetUsername =  findViewById(R.id.username);

        GetPassword =  findViewById(R.id.pass);

//        GetUserType = (EditText) findViewById(R.id.et_user_type);

        Get_user_type =  findViewById(R.id.user_type_spinner);


//        SET UP THE SPINNER DROPDOWN
        List<String> user_type = new ArrayList<>();
        user_type.add("Patient");
        user_type.add("Dr Ahmed");
        user_type.add("Dr Bliss");
        user_type.add("Dr Alex");
        user_type.add("Dr Brick");
        user_type.add("Dr Hunter");
        user_type.add("Dr Mistry");
        user_type.add("Dr Rash");
        user_type.add("Dr Spot");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.User_Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Get_user_type.setAdapter(adapter);
        Get_user_type.setOnItemSelectedListener(this);


        try {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                                         DBCreate();
                    SubmitData();

                }
            });
//
        }
        catch (SQLException e)
        {

        }

       save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                Intent i = new Intent(Login.this, Book_Appointment.class);
                startActivity(i);
//                DBCreate();
//                SAVEDATA();

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(Login.this, Create_Profile.class);
                startActivity(Signup);
            }
        });

    }

    public void DBCreate() {
        SQLITEDATABASE = openOrCreateDatabase("Bluecloud.db", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS login_Table (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username VARCHAR, password VARCHAR, user_type VARCHAR)");
    }

    public void SAVEDATA() {
        username = GetUsername.getText().toString();
        password = GetPassword.getText().toString();
        user_type = Get_user_type.getSelectedItem().toString();

        if (username.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_LONG).show();
        } else if (password.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();
        } else {

            SQLiteQuery = "insert into login_Table(username, password, user_type ) values('" + username + "','" + password + "', '" + user_type + "')";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            ClearEditTextAfterDoneTask();
            Toast.makeText(Login.this, "You'r Data Is Saved", Toast.LENGTH_LONG).show();

        }
    }

    public void SubmitData() {

//        Toast.makeText(Login.this, "Welcome To BlueCloud Medical Clinic Application", Toast.LENGTH_LONG).show();
        username = GetUsername.getText().toString();
        password = GetPassword.getText().toString();
        user_type = Get_user_type.getSelectedItem().toString();

        if (username.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_LONG).show();
        } else if (password.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();

        }
        else if(user_type.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Kindly select a User Type", Toast.LENGTH_LONG).show();
        }

        else if (myDBGETFROMCREATEPROFILE.checkUser(username, password)) {

            if (user_type.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Kindly select a User Type and now click the Login Button, Thanks.", Toast.LENGTH_LONG).show();
            }
                  Toast.makeText(Login.this, "Login", Toast.LENGTH_LONG).show();
                Toast.makeText(Login.this, "Welcome To BlueCloud Medical Clinic Application", Toast.LENGTH_LONG).show();


                switch (user_type) {
                    case "Patient":
                        i = new Intent(Login.this, MainActivity.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Ahmed":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Alex":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Bliss":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Brick":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Hunter":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Mistry":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Rash":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                    case "Dr Spot":
                        i = new Intent(Login.this, Patient_Prescription_Form.class);
                        i.putExtra("EMAIL", username);
                        startActivity(i);
                        break;
                }
//
//                i = new Intent(Login.this, Book_Appointment.class);

//


            }



           else  {
                Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Register Your Self", Toast.LENGTH_LONG).show();
            }
        }




//    SQLITEDATABASE = myLoginDB.getWritableDatabase();
//
//            cursor = SQLITEDATABASE.rawQuery("select * from  Create_Profile_Patient_Table where email=? and password=? " , new  String[]{username, password});
//
//
//           Toast.makeText(Login.this, "Login", Toast.LENGTH_LONG).show();
//            i = new Intent(Login.this, Book_Appointment.class);
//            startActivity(i);

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_dr__ahmed__tabbed_, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                Toast.makeText(getApplicationContext(), "Close Clicked ", Toast.LENGTH_LONG).show();
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }


//
    public void ClearEditTextAfterDoneTask()
    {
        GetUsername.getText().clear();
        GetPassword.getText().clear();
    }

//    public void GetSQLiteDatabaseRecord()
//    {
//        GetUsername.setText(cursor.getString(0));
//        GetPassword.setText(cursor.getString(1).toString());
//
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext()," Clicked = "+ text, Toast.LENGTH_LONG).show();

        if(parent.getItemAtPosition(position).equals("User_Type"))
        {

        }
        else
        {

            if(parent.getItemAtPosition(position).equals("Dr Rash"))
            {
//                Toast.makeText(parent.getContext()," Dr Rash ", Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Ahmed"))
            {
//                Toast.makeText(parent.getContext()," Dr Ahmed"+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Spot"))
            {
//                Toast.makeText(parent.getContext()," Dr Spot "+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Bliss"))
            {
//                Toast.makeText(parent.getContext()," Dr Spot "+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Alex"))
            {
//                Toast.makeText(parent.getContext()," Dr Alex "+ text, Toast.LENGTH_LONG).show();

            }
            else if(parent.getItemAtPosition(position).equals("Dr Hunter"))
            {
//                Toast.makeText(parent.getContext()," Dr Hunter "+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Mistry"))
            {
//                Toast.makeText(parent.getContext()," Dr Mistry "+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Dr Brick"))
            {
//                Toast.makeText(parent.getContext()," Dr Brick "+ text, Toast.LENGTH_LONG).show();
            }
            else if(parent.getItemAtPosition(position).equals("Patient"))
            {
//                Toast.makeText(parent.getContext()," Patient "+ text, Toast.LENGTH_LONG).show();
            }

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

