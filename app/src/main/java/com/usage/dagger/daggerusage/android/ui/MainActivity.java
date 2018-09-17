package com.usage.dagger.daggerusage.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.usage.dagger.daggerusage.android.App;
import com.usage.dagger.daggerusage.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getApp().getAppComponent().inject(this);
    }
}
