package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;

public class HD_Vid_Call extends AppCompatActivity {
    ImageView imageView;
    Button btn, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hd__video__call);
        btn = (Button) findViewById(R.id.btn28);
        btn1 = (Button) findViewById(R.id.btn29);
//        imageView = (ImageView) findViewById(R.id.imgView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HD_Vid_Call.this, Select_Doctors.class);
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent2 = new Intent(HD_Vid_Call.this, Select_Doctors.class);
//                startActivity(intent2);
            }
        });

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


}
