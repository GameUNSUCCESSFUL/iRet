package kku.photong.saitan.iret.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;

import java.io.File;
import java.text.DecimalFormat;

import kku.photong.saitan.iret.R;
import kku.photong.saitan.iret.activity.MainActivity;

/**
 * Created by Game on 12-Jan-17.
 */

public class PopUpsAge extends Activity implements View.OnClickListener {

    private final static int CAMERA_RQ = 6969;
    private final static int PERMISSION_RQ = 84;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.popups_age);

        Button button_ok = (Button) findViewById(R.id.button_ok);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Request permission to save videos in external storage
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_RQ);
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int hight = dm.heightPixels;

        getWindow().setLayout((int) (width * .2), (int) (hight * .1));

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopUpsAge.this,Camera.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
    }

}
