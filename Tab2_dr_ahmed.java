package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bluecloudmedicalclinic.Create_Patient.Book_Appointment;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Payment_Form;
import com.example.bluecloudmedicalclinic.R;

/**
 * Created by HP on 12/19/2019.
 */

public class Tab2_dr_ahmed extends Fragment {

    private Button book7, book8, book9, book10, book11, book12, book13, book14, book15, book16, book17;
    @Nullable
  private   View rootView;
    private Intent bookAppointment;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.tab2_dr_ahmed, container, false);
        book7 = (Button) rootView.findViewById(R.id.btn7);
        book8 = (Button) rootView.findViewById(R.id.btn8);
        book9 = (Button) rootView.findViewById(R.id.btn9);
        book10 = (Button) rootView.findViewById(R.id.btn10);
        book11 = (Button) rootView.findViewById(R.id.btn11);
        book12 = (Button) rootView.findViewById(R.id.btn12);
        book13 = (Button) rootView.findViewById(R.id.btn13);
        book14 = (Button) rootView.findViewById(R.id.btn14);
        book15 = (Button) rootView.findViewById(R.id.btn15);
        book16 = (Button) rootView.findViewById(R.id.btn16);
        book17 = (Button) rootView.findViewById(R.id.btn17);

        book7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });

        book8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });

        book9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });

        book11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment = new Intent( getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });
        book17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             bookAppointment =  new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(bookAppointment);
            }
        });

        return rootView;

    }
}
