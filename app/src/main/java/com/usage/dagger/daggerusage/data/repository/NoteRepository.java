package com.usage.dagger.daggerusage.data.repository;

import com.usage.dagger.daggerusage.data.dao.NoteDao;
import com.usage.dagger.daggerusage.domain.models.INote;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

import java.util.List;

public class NoteRepository implements INoteRepository {

    private NoteDao noteDao;

    public NoteRepository(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public List<INote> getAll() {
        return (List<INote>) noteDao.getAll();
    }

    @Override
    public List<INote> getOrderedByEditingDate(int offset, int limit) {
        return null;
    }

    @Override
    public List<INote> getOrderedByPriority(int offset, int limit) {
        return null;
    }

    @Override
    public List<INote> getCustomOrder(int offset, int limit) {
        return null;
    }

    @Override
    public void insert(INote note) {

    }

    @Override
    public void update(INote note) {

    }

    @Override
    public void delete(INote note) {

    }
}
