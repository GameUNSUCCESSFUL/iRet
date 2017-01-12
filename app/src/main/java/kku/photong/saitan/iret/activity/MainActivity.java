package kku.photong.saitan.iret.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import kku.photong.saitan.iret.R;
import kku.photong.saitan.iret.view.PopUpsAge;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = (Button) findViewById(R.id.scanButton);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.popups_age);
                //dialog.setCancelable(true);

/*                Button button1 = (Button)dialog.findViewById(R.id.button1);
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

                dialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
