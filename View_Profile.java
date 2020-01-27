package com.example.bluecloudmedicalclinic.Login;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluecloudmedicalclinic.R;

import org.w3c.dom.Text;

public class View_Profile extends AppCompatActivity {

    TextView tv1, tv2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__profile);
        btn = (Button) findViewById(R.id.cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv1 = (TextView) findViewById(R.id.id);
        tv1.setText(getIntent().getStringExtra("user_id"));

        tv2 = (TextView) findViewById(R.id.password);
        tv2.setText(getIntent().getStringExtra("user_pass"));

    }
}
