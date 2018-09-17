package com.usage.dagger.daggerusage.di.components;

import com.usage.dagger.daggerusage.android.ui.MainActivity;
import com.usage.dagger.daggerusage.di.modules.AppModule;
import com.usage.dagger.daggerusage.di.modules.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
