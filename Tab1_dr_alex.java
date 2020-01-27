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

import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Payment_Form;
import com.example.bluecloudmedicalclinic.R;

/**
 * Created by HP on 12/20/2019.
 */

public class Tab1_dr_alex extends Fragment {
    @Nullable
 private    View rootView;
    private Button book1, book2, book3, book4, book5, book6;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.tab1_dr__alex, container, false);
        book1 = (Button) rootView.findViewById(R.id.btn1);
        book2 = (Button) rootView.findViewById(R.id.btn2);
        book3 = (Button) rootView.findViewById(R.id.btn3);
        book4 = (Button) rootView.findViewById(R.id.btn4);
        book5 = (Button) rootView.findViewById(R.id.btn5);
        book6 = (Button) rootView.findViewById(R.id.btn6);

        assert book1 != null;
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        assert book2 != null;
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }
        });

        assert book3 != null;
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent2);
            }
        });

        assert book4 != null;
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent3);
            }
        });

        assert book5 != null;
        book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent4);
            }
        });

        assert book6 != null;
        book6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getActivity(), Patient_Payment_Form.class);
                Toast.makeText(getActivity(), "Complete you'r dues, Thanks.", Toast.LENGTH_LONG).show();
                startActivity(intent5);
            }
        });
        return rootView;

    }

}
