package com.example.bluecloudmedicalclinic.Create_Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bluecloudmedicalclinic.R;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Ahmed_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Alex_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Bliss_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Brick_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Hunter_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Mistry_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Rash_Tabbed_Activity;
import com.example.bluecloudmedicalclinic.Tabbed_Activity.Dr_Spot_Tabbed_Activity;

import java.util.ArrayList;
import java.util.List;

public class Book_appointment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText getDate;
    Button book_appointment;
    Spinner selectDoctors;
    String getDocotrs;
    Intent book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        book_appointment = findViewById(R.id.book);
        book_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToNext();
            }
        });

        selectDoctors = findViewById(R.id.spinner1);

//        Set up spinner
        List<String> getDoctors = new ArrayList<>();
        getDoctors.add("Dr Ahmed");
        getDoctors.add("Dr Bliss");
        getDoctors.add("Dr Alex");
        getDoctors.add("Dr Brick");
        getDoctors.add("Dr Hunter");
        getDoctors.add("Dr Mistry");
        getDoctors.add("Dr Rash");
        getDoctors.add("Dr Spot");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_doctor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDoctors.setAdapter(adapter);
        selectDoctors.setOnItemSelectedListener(this);

    }

    public void goToNext() {

             getDocotrs = selectDoctors.getSelectedItem().toString();

        if (getDocotrs.equals("")) {
            Toast.makeText(getApplicationContext(), "Kindly select a User Type", Toast.LENGTH_LONG).show();
        }
        switch (getDocotrs) {
            case "Dr Ahmed":
                book = new Intent(getApplicationContext(), Dr_Ahmed_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Bliss":
                book = new Intent(getApplicationContext(), Dr_Bliss_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Brick":
                book = new Intent(getApplicationContext(), Dr_Brick_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Alex":
                book = new Intent(getApplicationContext(), Dr_Alex_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Mistry":
                book = new Intent(getApplicationContext(), Dr_Mistry_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Hunter":
                book = new Intent(getApplicationContext(), Dr_Hunter_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Rash":
                book = new Intent(getApplicationContext(), Dr_Rash_Tabbed_Activity.class);
                startActivity(book);
                break;
            case "Dr Spot":
                book = new Intent(getApplicationContext(), Dr_Spot_Tabbed_Activity.class);
                startActivity(book);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext()," Clicked = "+ text, Toast.LENGTH_LONG).show();

        if(parent.getItemAtPosition(position).equals("select_doctors"))
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
