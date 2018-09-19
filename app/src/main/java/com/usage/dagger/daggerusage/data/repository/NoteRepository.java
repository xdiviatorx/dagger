package com.usage.dagger.daggerusage.data.repository;

import com.usage.dagger.daggerusage.data.dao.NoteDao;
import com.usage.dagger.daggerusage.data.mappers.NoteMapper;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

import java.util.List;
import java.util.Random;

public class NoteRepository implements INoteRepository {

    private NoteDao noteDao;
    private NoteMapper noteMapper;

    public NoteRepository(NoteDao noteDao, NoteMapper noteMapper) {
        this.noteDao = noteDao;
        this.noteMapper = noteMapper;

        // todo remove
        Random random = new Random(321213132);
        if (noteDao.getAll().size() < 1000) {
            for (int i = 0; i < 1000; ++i) {
                NoteModel note = new NoteModel();
                note.setTitle("Note #" + i);
                note.setText("My awesome note's text number #" + i);
                note.setPriority(random.nextInt(5) + 1);
                noteDao.insert(noteMapper.modelToEntity(note));
            }
        }
    }

    @Override
    public List<NoteModel> getAll() {
        return noteMapper.entityToModel(noteDao.getAll());
    }

    @Override
    public List<NoteModel> getOrderedByEditingDate(int offset, int limit) {
        return noteMapper.entityToModel(noteDao.getOrderedByEditingDate(offset, limit));
    }

    @Override
    public List<NoteModel> getOrderedByPriority(int offset, int limit) {
        return noteMapper.entityToModel(noteDao.getOrderedByPriority(offset, limit));
    }

    @Override
    public List<NoteModel> getCustomOrder(int offset, int limit) {
        return noteMapper.entityToModel(noteDao.getCustomOrder(offset, limit));
    }

    @Override
    public void insert(NoteModel note) {
        noteDao.insert(noteMapper.modelToEntity(note));
    }

    @Override
    public void update(NoteModel note) {
        noteDao.update(noteMapper.modelToEntity(note));
    }

    @Override
    public void delete(NoteModel note) {
        noteDao.delete(noteMapper.modelToEntity(note));
    }
}
