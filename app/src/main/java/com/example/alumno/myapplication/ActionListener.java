package com.example.alumno.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;

/**
 * Created by alumno on 08/06/2017.
 */

public class ActionListener implements View.OnClickListener{

    private Activity mainActivity;

    public ActionListener(Activity activity)
    {
        this.mainActivity = activity;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:42287853"));

        try
        {
            if (ActivityCompat.checkSelfPermission(mainActivity.getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this.mainActivity, new String[]{Manifest.permission.CALL_PHONE}, 0);
                return;
            }
            this.mainActivity.startActivity(intent);
        }
        catch (SecurityException e)
        {

        }
    }
}
