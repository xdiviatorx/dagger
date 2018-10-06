package com.usage.dagger.daggerusage.domain.usecase;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

public class AddNoteUseCase {

    private INoteRepository noteRepository;

    public AddNoteUseCase(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNewNote(NoteModel noteModel) {
        noteRepository.insert(noteModel);
    }
}
