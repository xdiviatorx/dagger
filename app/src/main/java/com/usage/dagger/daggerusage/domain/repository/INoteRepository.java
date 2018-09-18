package com.usage.dagger.daggerusage.domain.repository;

import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.util.List;

public interface INoteRepository {

    List<NoteModel> getAll();

    List<NoteModel> getOrderedByEditingDate(int offset, int count);

    List<NoteModel> getOrderedByPriority(int offset, int count);

    List<NoteModel> getCustomOrder(int offset, int count);

    void insert(NoteModel note);

    void update(NoteModel note);

    void delete(NoteModel note);
}
