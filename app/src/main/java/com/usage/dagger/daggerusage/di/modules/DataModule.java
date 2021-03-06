package com.usage.dagger.daggerusage.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.usage.dagger.daggerusage.data.AppDatabase;
import com.usage.dagger.daggerusage.data.dao.NoteDao;
import com.usage.dagger.daggerusage.data.mappers.NoteMapper;
import com.usage.dagger.daggerusage.data.repository.NoteRepository;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    private String databaseName;

    public DataModule(String databaseName) {
        this.databaseName = databaseName;
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Context context) {
        // todo remove allowance for in main thread usage
        return Room.databaseBuilder(context, AppDatabase.class, databaseName).allowMainThreadQueries().build();
    }

    @Provides
    public NoteDao provideNoteDatabase(AppDatabase appDatabase) {
        return appDatabase.noteDao();
    }

    @Provides
    public NoteMapper provideNoteMapper() {
        return new NoteMapper();
    }

    @Provides
    @Singleton
    public INoteRepository provideNoteRepository(NoteDao noteDao, NoteMapper noteMapper) {
        return new NoteRepository(noteDao, noteMapper);
    }
}
