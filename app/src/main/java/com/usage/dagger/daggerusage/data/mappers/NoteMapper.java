package com.usage.dagger.daggerusage.data.mappers;

import com.usage.dagger.daggerusage.data.entities.Note;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NotePriority;

import java.util.Date;

public class NoteMapper extends ModelEntityMapper<Note, NoteModel> {

    @Override
    public NoteModel entityToModel(Note note) {
        NoteModel model = new NoteModel();
        model.setId(note.id);
        model.setTitle(note.title);
        model.setText(note.text);
        model.setEditingDate(new Date(note.editingDate));
        model.setPriority(NotePriority.valueOf(note.priority));
        model.setOrderNumber(note.orderNumber);
        return model;
    }

    @Override
    public Note modelToEntity(NoteModel noteModel) {
        Note note = new Note();
        note.id = noteModel.getId();
        note.title = noteModel.getTitle();
        note.text = noteModel.getText();
        note.editingDate = noteModel.getEditingDate().getTime();
        note.priority = noteModel.getPriority().getIntValue();
        note.orderNumber = noteModel.getOrderNumber();
        return note;
    }
}
