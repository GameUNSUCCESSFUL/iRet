package kku.photong.saitan.iret.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kku.photong.saitan.iret.R;

/**
 * Created by Game on 12-Jan-17.
 */

public class Score extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_scor);
    }

    @Override
    public void onClick(View v) {

    }
}
