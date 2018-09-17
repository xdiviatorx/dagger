package com.usage.dagger.daggerusage.domain.repository;

import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.util.List;

public interface INoteRepository {

    List<NoteModel> getAll();

    List<NoteModel> getOrderedByEditingDate(int offset, int limit);

    List<NoteModel> getOrderedByPriority(int offset, int limit);

    List<NoteModel> getCustomOrder(int offset, int limit);

    void insert(NoteModel note);

    void update(NoteModel note);

    void delete(NoteModel note);
}
