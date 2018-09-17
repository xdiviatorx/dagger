package com.usage.dagger.daggerusage.android;

import android.app.Application;

import com.usage.dagger.daggerusage.di.DaggerAppComponent;
import com.usage.dagger.daggerusage.di.components.AppComponent;
import com.usage.dagger.daggerusage.di.modules.AppModule;
import com.usage.dagger.daggerusage.di.modules.DataModule;
import com.usage.dagger.daggerusage.domain.Const;

public class App extends Application {

    private static App instance = null;

    private AppComponent appComponent = null;

    public static App getApp() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .dataModule(new DataModule(Const.DATABASE_NAME))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
