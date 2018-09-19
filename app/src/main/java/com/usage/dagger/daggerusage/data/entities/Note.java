package com.usage.dagger.daggerusage.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String text;
    public long editingDate;
    public int priority;
    public int orderNumber;
}
