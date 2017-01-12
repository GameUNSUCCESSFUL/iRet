package kku.photong.saitan.iret.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.app.Dialog;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.afollestad.materialdialogs.folderselector.FileChooserDialog;
import com.afollestad.materialdialogs.folderselector.FolderChooserDialog;
import com.afollestad.materialdialogs.util.DialogUtils;

import java.io.File;


import butterknife.ButterKnife;
import butterknife.OnClick;

import kku.photong.saitan.iret.R;
import kku.photong.saitan.iret.view.Camera;

public class MainActivity extends AppCompatActivity implements
        FolderChooserDialog.FolderCallback,View.OnClickListener, FileChooserDialog.FileCallback, ColorChooserDialog.ColorCallback, NumberPicker.OnValueChangeListener {

    // Custom View Dialog
    private TextView textView;
    private EditText passwordInput;
    private View positiveAction;
    // color chooser dialog
    private int primaryPreselect;

    // UTILITY METHODS
    private int accentPreselect;
    private Toast toast;
    private Thread thread;
    private Handler handler;

    private int chooserDialog;

    private void showToast(String message) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }


    private void startThread(Runnable run) {
        if (thread != null)
            thread.interrupt();
        thread = new Thread(run);
        thread.start();
    }

    private void showToast(@StringRes int message) {
        showToast(getString(message));
    }

    // ------------
    private final static int CAMERA_RQ = 6969;
    private final static int PERMISSION_RQ = 84;
    // BEGIN SAMPLE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = (Button) findViewById(R.id.scanButton);
        Button testbut = (Button) findViewById(R.id.testbut);
//        testbut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Camera.class));
//            }
//        });
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*              Button button1 = (Button)dialog.findViewById(R.id.button1);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext()
                                , "Close dialog", Toast.LENGTH_SHORT);
                        dialog.cancel();
                    }
                });

                TextView textView1 = (TextView)dialog.findViewById(R.id.textView1);
                textView1.setText("Custom Dialog");
                TextView textView2 = (TextView)dialog.findViewById(R.id.textView2);
                textView2.setText("Try it yourself");*/
                show();
            }
        });

        //-----------------------------------------------------------------
        ButterKnife.bind(this);

        handler = new Handler();
        primaryPreselect = DialogUtils.resolveColor(this, R.attr.colorPrimary);
        accentPreselect = DialogUtils.resolveColor(this, R.attr.colorAccent);
    }

    public void show(){
//        final Dialog dialog = new Dialog(MainActivity.this);
////        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.popups_age);
////        dialog.show();
////        dialog.setCancelable(true);
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            // Request permission to save videos in external storage
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_RQ);
//        }
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int hight = dm.heightPixels;
//
//        getWindow().setLayout((int) (width * .2), (int) (hight * .1));
//
//        dialog.show();
        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.popups_age);
        Button b1 = (Button) d.findViewById(R.id.button_ok);
//        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numpicker);
        np.setMaxValue(100); // max value 100
        np.setMinValue(0);   // min value 0
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Camera.class));
            }
        });
        d.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (thread != null && !thread.isInterrupted() && thread.isAlive())
            thread.interrupt();
    }

    @OnClick(R.id.testbut)
    public void showBasicNoTitle() {
        new MaterialDialog.Builder(this)
                .content(R.string.shareLocationPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onFolderSelection(@NonNull FolderChooserDialog dialog, @NonNull File folder) {

    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {

    }

    @Override
    public void onFileSelection(@NonNull FileChooserDialog dialog, @NonNull File file) {

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }
}
