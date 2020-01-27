package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.content.Intent;
import android.net.Uri;
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

public class Dr_Ahmed extends AppCompatActivity {
     TextView tv;
    Button VoiceCall, VideoCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_ahmed);


        VoiceCall = (Button) findViewById(R.id.btn_voice_call);

        VideoCall = (Button) findViewById(R.id.btn_video_call);

      VoiceCall.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent voice_call = new Intent(Dr_Ahmed.this, Voice_Call.class);
              startActivity(voice_call);
          }
      });

        VideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video_call = new Intent(Dr_Ahmed.this, Video_Call.class);
                startActivity(video_call);
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
