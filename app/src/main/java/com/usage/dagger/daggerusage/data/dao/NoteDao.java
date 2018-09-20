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

    @Query("select * from note order by note.editingDate desc limit :offset, :count")
    List<Note> getOrderedByEditingDate(int offset, int count);

    @Query("select * from note order by note.priority limit :offset, :count")
    List<Note> getOrderedByPriority(int offset, int count);

    @Query("select * from note order by note.orderNumber limit :offset, :count")
    List<Note> getCustomOrder(int offset, int count);

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
