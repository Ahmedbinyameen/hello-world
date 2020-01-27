package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Build;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.Login.Login;
import com.example.bluecloudmedicalclinic.R;


public class Video_Call extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public  static  final  int CAMERA_REQUEST = 1888;
    private static final  int MY_CAMERA_PERMISSION_CODE = 101;
    ImageView imageView;
    AlertDialog.Builder builder;
    //    Spinner selectDoctors;
    ImageButton VideoCall;
    Intent call_intent;
    Spinner selectDoctor;
    String GetDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__call);
        builder = new AlertDialog.Builder(this);

        selectDoctor = (Spinner) findViewById(R.id.user_type_spinner);

//          GetDoctor= selectDoctor.getSelectedItem().toString();




        VideoCall = (ImageButton) findViewById(R.id.btn_video_call);

        VideoCall.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override

            public void onClick(View v) {

                builder.setMessage("BlueCloud Medical Clinic").setTitle("Video Call").setIcon(R.drawable.ic_warning_black_24dp);
                builder.setMessage("Do you want to Video Call with " + selectDoctor.getSelectedItem().toString() + " ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                gotoNextPage();

//                                if (getApplicationContext().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//
//
//                                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
//
//                                } else {
//
//
//                                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
//
//                                }

                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Okay...", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("BlueCloud Medical Application");
                alert.show();


            }
        });

//        selectDoctors = (Spinner) findViewById(R.id.spinner1);
//
//        List<String> sel_doctors = new ArrayList<>();
//        sel_doctors.add("Dr Ahmed");
//        sel_doctors.add("Dr Bliss");
//        sel_doctors.add("Dr Alex");
//        sel_doctors.add("Dr Brick");
//        sel_doctors.add("Dr Hunter");
//        sel_doctors.add("Dr Mistry");
//        sel_doctors.add("Dr Rash");
//        sel_doctors.add("Dr Spot");


//        Spinner spinner = (Spinner) findViewById(R.id.user_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_doctor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDoctor.setAdapter(adapter);
        selectDoctor.setOnItemSelectedListener(this);


    }

    public void gotoNextPage()
    {
        String getText = selectDoctor.getSelectedItem().toString();
        Intent intent = new Intent(getApplicationContext(), Video_Call_2.class);
        intent.putExtra("doctor_name", getText);
        startActivity(intent);
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == CAMERA_REQUEST)
//        {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(bitmap);
//        }
//
//
//    }

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



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), " Selected = " + text, Toast.LENGTH_LONG).show();

        if (parent.getItemAtPosition(position).equals("select_doctor")) {

        } else {

            if (parent.getItemAtPosition(position).equals("Dr Rash")) {

//                Intent i = new Intent(getApplicationContext(), Video_Call_Activity2.class);
//                i.putExtra("doctor_name", text);
//                startActivity(i);



            } else if (parent.getItemAtPosition(position).equals("Dr Ahmed")) {


            } else if (parent.getItemAtPosition(position).equals("Dr Spot")) {


            } else if (parent.getItemAtPosition(position).equals("Dr Bliss")) {


            } else if (parent.getItemAtPosition(position).equals("Dr Alex")) {



            } else if (parent.getItemAtPosition(position).equals("Dr Hunter")) {


            } else if (parent.getItemAtPosition(position).equals("Dr Mistry")) {


            } else if (parent.getItemAtPosition(position).equals("Dr Brick")) {


            }

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == MY_CAMERA_PERMISSION_CODE)
//        {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                Toast.makeText(getApplicationContext(), "camera permission granted", Toast.LENGTH_LONG).show();
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//            }
//            else
//            {
//                Toast.makeText(getApplicationContext(), "camera permission denied", Toast.LENGTH_LONG).show();
//            }
//        }
//    }




}
