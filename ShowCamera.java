package com.example.bluecloudmedicalclinic.Voice_Call_And_Video_Call;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;
import java.util.List;

/**
 * Created by HP on 1/17/2020.
 */

public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback {


    private android.hardware.Camera camera;
    private SurfaceHolder msurfaceHolder;

    public ShowCamera(Context context, android.hardware.Camera mycamera) {
        super(context);
        this.camera = mycamera;
        msurfaceHolder = getHolder();
        msurfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

       android.hardware.Camera.Parameters parameters = camera.getParameters();

       List<android.hardware.Camera.Size> sizes = parameters.getSupportedPictureSizes();
//        List<android.hardware.Camera.Size> sizes = parameters.getSupportedPictureSizes();
       android.hardware.Camera.Size mSize = null;
//        android.hardware.Camera.Size mSize = null;

        for (Camera.Size size : sizes)
        {
            mSize = size;
        }

//        for(android.hardware.Camera.Size size : sizes)
//        {
//            mSize = size;
//        }


//        change the orientation
        if(this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE)
        {

            parameters.set("orientation", "portrait");
            camera.setDisplayOrientation(0);
            parameters.setRotation(0);
        }
        else
        {
            parameters.set("orientation", "landscape");
            camera.setDisplayOrientation(90);
            parameters.setRotation(90);
        }


        parameters.setPictureSize(mSize.width, mSize.height);
        camera.setParameters(parameters);
        try {

            camera.setPreviewDisplay(msurfaceHolder);
            camera.startPreview();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        camera.stopPreview();
        camera.release();

    }
}
