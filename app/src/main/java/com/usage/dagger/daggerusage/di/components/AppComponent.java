package com.usage.dagger.daggerusage.di.components;

import com.usage.dagger.daggerusage.android.activities.NoteCreateActivity;
import com.usage.dagger.daggerusage.android.activities.MainActivity;
import com.usage.dagger.daggerusage.di.modules.AddNoteScreenModule;
import com.usage.dagger.daggerusage.di.modules.AppModule;
import com.usage.dagger.daggerusage.di.modules.DataModule;
import com.usage.dagger.daggerusage.di.modules.NoteListScreenModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, NoteListScreenModule.class,
        AddNoteScreenModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(NoteCreateActivity noteCreateActivity);
}
