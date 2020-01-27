package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bluecloudmedicalclinic.R;


public class Video_Call_2 extends AppCompatActivity implements SurfaceHolder.Callback {

    TextView show_doc_name;
    TextView show_doc_num, hour, show_time, seconds, ringing, calling, call_end;
    ImageButton call, cancel, microphone_off, switchCamera;
    String value, value2, getCalling, getRinging;
    private static final int CAMERA_REQUEST = 999;
    private static final int Video_Capture = 101;
    Intent cameraIntent;
    boolean ismicrophone = false;
    VideoView getViewVideo;
    public int counter;
    private Chronometer mchronometer;
    private boolean cameraFront = false;
    private AudioManager myAudioManager;
    // For Texture View
//     TextureView textureView;
//    private TextureView.SurfaceTextureListener mSufaceTexture = new TextureView.SurfaceTextureListener() {
//        @Override
//        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//
//            Toast.makeText(getApplicationContext(), "Hello...", Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//
//        }
//
//        @Override
//        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
//            return false;
//        }
//
//        @Override
//        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
//
//        }
//    };

    FrameLayout frameLayout;
    Camera camera;
    ShowCamera showCamera;
    //Counter
//    int repeatCounter = 1;
    CountDownTimer timer;
//    private String[] neededPermission = new String[]{CAMERA};
//    private SurfaceView surfaceView;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__call_2);


        mchronometer = findViewById(R.id.chronometer);
        mchronometer.setBase(SystemClock.elapsedRealtime());
        mchronometer.start();

        getCalling = calling.getText().toString();
        getRinging = ringing.getText().toString();

        frameLayout = findViewById(R.id.Videoframe);

        //Open the Camera:
        camera = Camera.open();
        showCamera = new ShowCamera(this, camera);
        frameLayout.addView(showCamera);

//        textureView = (TextureView) findViewById(R.id.texture_view);


//        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(this);
//        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


//        getViewVideo = (VideoView) findViewById(R.id.video_view);

        call_end = findViewById(R.id.call_end);
        calling = findViewById(R.id.showing_calling);
        calling.setText("");
        ringing = findViewById(R.id.ringing);
        ringing.setText("ringing...");


//        getViewVideo = (VideoView) findViewById(R.id.video_view);

        microphone_off = findViewById(R.id.microphone_off);

        switchCamera = findViewById(R.id.switch_camera);


//       hour  = (TextView) findViewById(R.id.hour);
//        show_time = (TextView) findViewById(R.id.time);
//        seconds = (TextView) findViewById(R.id.seconds);


        show_doc_num = findViewById(R.id.showing_number);

        show_doc_name = findViewById(R.id.doc_name);

        value = getIntent().getStringExtra("doctor_name");

        value2 = getIntent().getStringExtra("doctor_name");

        show_doc_name.setText(value);

        show_doc_num.setText(value2);

        call = findViewById(R.id.btn_for_call);

//        cancel = (ImageButton) findViewById(R.id.cancel);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hasCamera();
                finish();
                show_doc_num.setText("");
                ringing.setText("");
                calling.setText("");
                mchronometer.stop();
                call_end.setText("call ended");

//                startActivityForResult(camera, Video_Capture);

            }
        });

        switchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int camerasNumber = Camera.getNumberOfCameras();
                if (camerasNumber > 1) {
                    chooseCamera();
                } else {
                    Toast.makeText(getApplicationContext(), "Try Again...", Toast.LENGTH_LONG).show();
                }

            }
        });

        myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        microphone_off.setBackgroundResource(R.drawable.ic_microphone_off_white_24dp);
        microphone_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ismicrophone) {

                    v.setBackgroundResource(R.drawable.ic_microphone_off_white_24dp);
                    v.setBackgroundColor(Color.parseColor("#070100"));
                    Toast.makeText(getApplicationContext(), "Microphone is off...", Toast.LENGTH_LONG).show();

                } else {
                    v.setBackgroundResource(R.drawable.ic_microphone_white_24dp);
                    v.setBackgroundColor(Color.parseColor("#302E2F"));
                    myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    Toast.makeText(getApplicationContext(), "Microphone is on...", Toast.LENGTH_LONG).show();
                }

                ismicrophone = !ismicrophone;

            }
        });

    }

//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });



//    For TEXTURE View
//    @Override
//    protected void  onResume()
//    {
//        super.onResume();
//        if(textureView.isAvailable())
//        {
//
//        }
//        else
//        {
//            textureView.setSurfaceTextureListener(mSufaceTexture);
//        }
//    }

//    CountDownTime...........................................................

//   public void user()
//    {
//        if(getCalling.equals(calling))
//        {
//            ringing.setText("ringing");
//        }
//        else
//        {
//            ringing.setText("");
//        }
//    }

    //               For Switch Camera..............................................................

    private int findFrontFacingCamera()
    {
        int cameraID = -1;
        int numberOfCamera= Camera.getNumberOfCameras();
        for(int i=0; i< numberOfCamera; i++)
        {
            android.hardware.Camera.CameraInfo info = new Camera.CameraInfo();
            android.hardware.Camera.getCameraInfo(i, info);
            if(info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT)
            {
                cameraID = i;
                cameraFront  = true;
                break;

            }
        }
        return  cameraID;
    }

    private int findBackFacingCamera()
    {
        int cameraID = -1;
        int numberOfCamera = Camera.getNumberOfCameras();
        for(int j =0; j<numberOfCamera; j++)
        {
            Camera.CameraInfo info = new Camera.CameraInfo();
           Camera.getCameraInfo(j, info);
            if(info.facing == Camera.CameraInfo.CAMERA_FACING_BACK)
            {
                cameraID = -1;
                cameraFront = false;
                break;
            }
        }
        return cameraID;
    }

    public void  chooseCamera()
    {
        if(cameraFront)
        {
            int cameraID = findFrontFacingCamera();
            if(cameraID >= 0)
            {
                camera = Camera.open(cameraID);
                camera.setDisplayOrientation(90);

            }
            else {
                int cameraId = findBackFacingCamera();
                if (cameraId >= 0)
                {
                    camera = Camera.open(cameraId);
                    camera.setDisplayOrientation(90);
                }
            }
        }
    }


//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public  static  String getDateFromMills(long d)
//    {
//        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
//        df.setTimeZone(TimeZone.getTimeZone("GMT"));
//        return df.format(d);
//    }


//    private void setProgressBarValue()
//    {
//        pb.setMax(time / timeInterval);
//        pb.setProgress(time / timeInterval);
//    }

//    public void checkTextview()
//    {
////        if (!timer.start()) {
////            calling.setEnabled(false);
////        } else {
////            ringing.setEnabled(true);
////        }
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Uri videoUri = data.getData();
//        if(requestCode == Video_Capture)
//        {
//            if(resultCode == RESULT_OK)
//            {
//                Toast.makeText(getApplicationContext(), "Video Saved to :\n " + videoUri, Toast.LENGTH_LONG).show();
//            }
//            else if(resultCode == RESULT_CANCELED)
//            {
//                Toast.makeText(getApplicationContext(), "Video recording canceled :\n " , Toast.LENGTH_LONG).show();
//            }
//            else
//            {
//                Toast.makeText(getApplicationContext(), "Failed to record Video :\n " + videoUri, Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.video_call, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clear) {
            finish();
            Toast.makeText(getApplicationContext(), "Close...", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }

//    private boolean hasCamera()
//    {
//        return  (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS));
//    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
