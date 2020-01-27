package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;


public class Select_Doctors extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Button btn1;

    public  static  final  int CAMERA_REQUEST = 9999;
    ImageView imageView;
    EditText edit1;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__doctors);


        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_doctor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

//    public  void  OpenCamera(View view)
//    {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, CAMERA_REQUEST);
//    }
//
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext()," Selected = "+ text, Toast.LENGTH_LONG).show();

        if(parent.getItemAtPosition(position).equals("select_doctor"))
        {

        }
        else
        {

            if(parent.getItemAtPosition(position).equals("Dr Rash"))
            {

                Intent intent3 = new Intent(Select_Doctors.this, Dr_Rash.class);
                startActivity(intent3);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Ahmed"))
            {

                Intent intent1 = new Intent(Select_Doctors.this, Dr_Ahmed.class);
                startActivity(intent1);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Spot"))
            {

                Intent intent4 = new Intent(Select_Doctors.this, Dr_Spot.class);
                startActivity(intent4);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Bliss"))
            {

                Intent intent2 = new Intent(Select_Doctors.this, Dr_Bliss.class);
                startActivity(intent2);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Alex"))
            {

                Intent intent5 = new Intent(Select_Doctors.this, dr_alex.class);
                startActivity(intent5);

            }
            else if(parent.getItemAtPosition(position).equals("Dr Hunter"))
            {

                Intent intent6 = new Intent(Select_Doctors.this, Dr_Hunter.class);
                startActivity(intent6);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Mistry"))
            {

                Intent intent7 = new Intent(Select_Doctors.this, Dr_Mistry.class);
                startActivity(intent7);
            }
            else if(parent.getItemAtPosition(position).equals("Dr Brick"))
            {

                Intent intent8 = new Intent(Select_Doctors.this, Dr_Brick.class);
                startActivity(intent8);
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
                Toast.makeText(getApplicationContext(), "Close Clicked ", Toast.LENGTH_LONG).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
