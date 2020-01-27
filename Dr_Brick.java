package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;


public class Dr_Brick extends AppCompatActivity {
TextView tv;
    Button VoiceCall, VideoCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr__brick);

        VoiceCall = (Button) findViewById(R.id.btn_voice_call);

        VideoCall = (Button) findViewById(R.id.btn_video_call);
        VoiceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent voice_call = new Intent(Dr_Brick.this, Voice_Call.class);
                startActivity(voice_call);
            }
        });

        VideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video_call = new Intent(Dr_Brick.this, Video_Call.class);
                startActivity(video_call);
            }
        });


//        tv = (TextView) findViewById(R.id.tv57);
//        tv.setText( getIntent().getStringExtra("Date"));
//        bt= (Button) findViewById(R.id.btn1);
//        bt1= (Button) findViewById(R.id.btn2);
//        bt2= (Button) findViewById(R.id.btn3);
//        bt3= (Button) findViewById(R.id.btn4);
//        btn4 = (Button) findViewById(R.id.btn5);
//        btn5 = (Button) findViewById(R.id.btn6);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });
//        bt3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(Dr_Brick.this, Login.class );
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dr__brick__tabbed_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Close Clicked", Toast.LENGTH_LONG).show();
//                Intent Tabbed_Screen = new Intent(Dr_Brick.this, Dr_Brick_Tabbed_Activity.class);
//                startActivity(Tabbed_Screen);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
