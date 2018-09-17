package com.usage.dagger.daggerusage.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.usage.dagger.daggerusage.data.dao.NoteDao;
import com.usage.dagger.daggerusage.data.entities.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
