package com.example.bluecloudmedicalclinic.Navigation_Bar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Create_Patient.Book_Appointment;
import com.example.bluecloudmedicalclinic.Create_Patient.Create_Profile;
import com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call.HD_Vid_Call;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.MainActivity;
import com.example.bluecloudmedicalclinic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Bottom_Nav extends AppCompatActivity {

   TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent1 = new Intent(Main_Bottom_Nav.this, MainActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_Medicine:
                    Intent intent2 = new Intent(Main_Bottom_Nav.this, Book_Appointment.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_Call:
                    Intent intent3 = new Intent(Main_Bottom_Nav.this, HD_Vid_Call.class);
                    startActivity(intent3);
                    return true;
                case R.id.navigation_Recent:
                    Intent intent4 = new Intent(Main_Bottom_Nav.this, Create_Profile.class);
                    startActivity(intent4);
                    return  true;
                case R.id.navigation_Subscription:
                    Intent intent5 = new Intent(Main_Bottom_Nav.this, Login.class);
                    startActivity(intent5);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__bottom__nav);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
