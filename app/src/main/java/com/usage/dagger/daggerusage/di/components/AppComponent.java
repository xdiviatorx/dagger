package com.usage.dagger.daggerusage.di.components;

import com.usage.dagger.daggerusage.android.activities.MainActivity;
import com.usage.dagger.daggerusage.di.modules.AppModule;
import com.usage.dagger.daggerusage.di.modules.DataModule;
import com.usage.dagger.daggerusage.di.modules.NoteListActivityModule;
import com.usage.dagger.daggerusage.di.modules.NoteModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, NoteModule.class, NoteListActivityModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
