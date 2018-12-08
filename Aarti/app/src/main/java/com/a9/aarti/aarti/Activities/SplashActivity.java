package com.a9.aarti.aarti.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, AartiListActvity.class);
        startActivity(intent);
        finish();

    }
}
