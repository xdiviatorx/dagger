package com.usage.dagger.daggerusage.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.usage.dagger.daggerusage.data.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("select * from note")
    List<Note> getAll();

    @Query("select * from note order by note.editingDate desc limit :offset, :limit")
    List<Note> getOrderedByEditingDate(int offset, int limit);

    @Query("select * from note order by note.priority limit :offset, :limit")
    List<Note> getOrderedByPriority(int offset, int limit);

    @Query("select * from note order by note.editingDate desc limit :offset, :limit")
    List<Note> getCustomOrder(int offset, int limit);

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
