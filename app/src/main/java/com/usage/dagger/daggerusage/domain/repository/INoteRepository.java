package com.usage.dagger.daggerusage.domain.repository;

import com.usage.dagger.daggerusage.domain.models.INote;

import java.util.List;

public interface INoteRepository {

    List<INote> getAll();

    List<INote> getOrderedByEditingDate(int offset, int limit);

    List<INote> getOrderedByPriority(int offset, int limit);

    List<INote> getCustomOrder(int offset, int limit);

    void insert(INote note);

    void update(INote note);

    void delete(INote note);
}
