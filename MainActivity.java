package com.example.bluecloudmedicalclinic;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Create_Patient.Book_Appointment;
import com.example.bluecloudmedicalclinic.Menu_Bar_Home_Page.Blog;
import com.example.bluecloudmedicalclinic.Menu_Bar_Home_Page.Faq;
import com.example.bluecloudmedicalclinic.Menu_Bar_Home_Page.PrEP;
import com.example.bluecloudmedicalclinic.Menu_Bar_Home_Page.STD;
import com.example.bluecloudmedicalclinic.Menu_Bar_Home_Page.Services;
import com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription.Patient_Payment_Receipt_PDF;

public class MainActivity extends AppCompatActivity {

    Button bt;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(intent1);
//                    return true;
//                case R.id.navigation_Medicine:
//                    Intent intent2 = new Intent(MainActivity.this, Book_Appointment.class);
//                    startActivity(intent2);
//                    return true;
//                case R.id.navigation_Call:
//                    Intent intent3 = new Intent(MainActivity.this, HD_Vid_Call.class);
//                    startActivity(intent3);
//                    return true;
//                case R.id.navigation_Recent:
//                    Intent intent4 = new Intent(MainActivity.this, Create_Profile.class);
//                    startActivity(intent4);
//                    return  true;
//                case R.id.navigation_Subscription:
//                    Intent intent5 = new Intent(MainActivity.this, Login.class);
//                    startActivity(intent5);
//                    return true;
//            }
//            return false;
//        }
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.btn2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Book_Appointment.class);
                startActivity(intent);
            }
        });

//        try {
//
//            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        }
//        catch (NullPointerException ignored)
//        {
//
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                Toast.makeText(this, "Home Selected" , Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return  true;
            case R.id.service:
                Toast.makeText(this, "Service Selected", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, Services.class);
                this.startActivity(intent2);
                return true;
            case R.id.service1:
                Toast.makeText(this, "PrEP Selected", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(this, PrEP.class);
                this.startActivity(intent3);
                return true;
            case R.id.service2:
                Toast.makeText(this, "STD Selected", Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(this, STD.class);
                this.startActivity(intent4);
                return true;
            case R.id.blog:
                Toast.makeText(this, "Blog Selected", Toast.LENGTH_LONG).show();
                Intent intent5 = new Intent(this, Blog.class);
                this.startActivity(intent5);
                return true;
            case R.id.faq:
                Toast.makeText(this, "Faq Selected", Toast.LENGTH_LONG).show();
                Intent intent6 = new Intent(this, Faq.class);
                this.startActivity(intent6);
                return true;
            default:
                return  super.onOptionsItemSelected(item);

        }
    }

}




