package com.example.bluecloudmedicalclinic.List_View;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.db.SQLiteListAdapter;
import com.example.bluecloudmedicalclinic.db.SQLitePatientPaymentHelper;

import java.util.ArrayList;


public class List_View extends AppCompatActivity {

//    SQLiteCreateProfileHelper ;

//    SQLitePrescriptionHelper myPrescriptionHelper;

    SQLitePatientPaymentHelper myPatientPaymentHelper;

    Button Cancel;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> PatientID_ArrayList = new ArrayList<String>();
    ArrayList<String> FirstName_ArrayList = new ArrayList<String>();
    ArrayList<String> LastName_ArrayList = new ArrayList<String>();
    ArrayList<String> Zip_ArrayList = new ArrayList<String>();
    ArrayList<String> Location_ArrayList = new ArrayList<String>();
    ArrayList<String> Amount_ArrayList = new ArrayList<String>();
    ArrayList<String> Card_Number_ArrayList = new ArrayList<String>();
    ArrayList<String> Expiry_Date_ArrayList = new ArrayList<String>();
    ArrayList<String> Card_Holder_Name_ArrayList = new ArrayList<String>();
    ArrayList<String> Email_ArrayList = new ArrayList<String>();



    ListView LISTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);

        Toast.makeText(List_View.this, "Patient Payment Form", Toast.LENGTH_LONG).show();
        LISTVIEW = (ListView) findViewById(R.id.list);

        myPatientPaymentHelper = new SQLitePatientPaymentHelper(this);

//        Cancel = (Button) findViewById(R.id.btn_cancel);
//
//        try {
//            Cancel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
//        }
//        catch (NullPointerException ignored)
//        {
//
//        }


//        SQLITEHELPER = new SQLiteCreateProfileHelper(this);

    }

    public void onResume()
    {
        ShowSQLiteDBData();
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_view, menu);
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

    private void ShowSQLiteDBData() {


        SQLITEDATABASE = myPatientPaymentHelper.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM New_Patient_Table", null);

        PatientID_ArrayList.clear();
        FirstName_ArrayList.clear();
        LastName_ArrayList.clear();
        Zip_ArrayList.clear();
        Location_ArrayList.clear();
        Amount_ArrayList.clear();
        Card_Number_ArrayList.clear();
        Expiry_Date_ArrayList.clear();
        Card_Holder_Name_ArrayList.clear();
        Email_ArrayList.clear();


        if (cursor.moveToFirst()) {
            do {
                PatientID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_ID)));

                FirstName_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_FIRST_NAME)));

                LastName_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_LAST_NAME)));

                Zip_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_ZIP)));

                Location_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_LOCATION)));

               Amount_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_AMOUNT)));

               Card_Number_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_CARD_NUMBER)));

                Expiry_Date_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_CARD_EXP)));

                Card_Holder_Name_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_CARD_HOLDER_NAME)));

                Email_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLitePatientPaymentHelper.COLUMN_EMAIL)));



            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(List_View.this,
                PatientID_ArrayList,
        FirstName_ArrayList,
        LastName_ArrayList,
        Zip_ArrayList,
        Location_ArrayList,
        Amount_ArrayList,
                Card_Number_ArrayList,
        Expiry_Date_ArrayList,
        Card_Holder_Name_ArrayList,
        Email_ArrayList

        );

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
    }
}

