package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.bluecloudmedicalclinic.Finish_Pay;
import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.R;


public class Voice_Call extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    EditText phone_number;
    Button VoiceCall;
    Intent call_intent;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice__call);

        builder = new AlertDialog.Builder(this);

        phone_number = (EditText) findViewById(R.id.number);

        VoiceCall = (Button) findViewById(R.id.btn_voice_call);


        VoiceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//               call_intent= new Intent(Voice_Call.this, HD_Vid_Call.class);
//                startActivity(call_intent);
                makePhoneCall();

            }
        });


    }

    public void makePhoneCall()
    {
        String number = phone_number.getText().toString();
        if (number.trim().length()>0)
        {

            if (ContextCompat.checkSelfPermission(Voice_Call.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Voice_Call.this,
                        new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }
            else {

                String dial = "tel:" + number;
                call_intent = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                startActivity(call_intent);

            }
        }
        else
        {
            Toast.makeText(Voice_Call.this, "Enter Phone Number", Toast.LENGTH_LONG).show();
        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         if (requestCode == REQUEST_CALL)
         {
             if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
             {
                 makePhoneCall();
             }
             else
             {
                 Toast.makeText(Voice_Call.this, "Permission Denied", Toast.LENGTH_LONG).show();
             }
         }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dr__ahmed__tabbed_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                builder.setMessage(R.string.dialog_msg).setTitle(R.string.title);
                builder.setMessage("Do you want to Close ? ")
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
                return true;
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

                AlertDialog alert1 = builder.create();
                alert1.setTitle("BlueCloud Medical Application");
                alert1.show();

            default:
                return super.onOptionsItemSelected(item);
        }

    }



}
