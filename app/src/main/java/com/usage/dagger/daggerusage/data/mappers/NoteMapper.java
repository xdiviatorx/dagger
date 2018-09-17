package com.usage.dagger.daggerusage.data.mappers;

import com.usage.dagger.daggerusage.data.entities.Note;
import com.usage.dagger.daggerusage.domain.models.NoteModel;

public class NoteMapper extends ModelEntityMapper<Note, NoteModel> {

    @Override
    public NoteModel entityToModel(Note note) {
        NoteModel model = new NoteModel();
        model.setId(note.id);
        model.setTitle(note.title);
        model.setText(note.text);
        model.setEditingDate(note.editingDate);
        model.setPriority(note.priority);
        model.setOrderNumber(note.orderNumber);
        return model;
    }

    @Override
    public Note modelToEntity(NoteModel noteModel) {
        Note note = new Note();
        note.id = noteModel.getId();
        note.title = noteModel.getTitle();
        note.text = noteModel.getText();
        note.editingDate = noteModel.getEditingDate();
        note.priority = noteModel.getPriority();
        note.orderNumber = noteModel.getOrderNumber();
        return note;
    }
}
