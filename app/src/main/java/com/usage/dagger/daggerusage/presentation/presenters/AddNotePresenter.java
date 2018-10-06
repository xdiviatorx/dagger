package com.usage.dagger.daggerusage.presentation.presenters;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NotePriority;
import com.usage.dagger.daggerusage.domain.usecase.AddNoteUseCase;
import com.usage.dagger.daggerusage.presentation.views.AddNoteView;

import java.util.Date;

public class AddNotePresenter {

    private final AddNoteUseCase addNoteUseCase;
    private NoteModel noteModel;
    private AddNoteView view;

    public AddNotePresenter(AddNoteUseCase addNoteUseCase, NoteModel noteModel) {
        this.addNoteUseCase = addNoteUseCase;
        this.noteModel = noteModel;
    }

    public void attachView(AddNoteView view) {
        this.view = view;
    }

    public void onNoteTitleChanged(String title) {
        noteModel.setTitle(title);
    }

    public void onNoteTextChanged(String text) {
        noteModel.setText(text);
    }

    public void onSaveRequested() {
        noteModel.setPriority(NotePriority.URGENT_AND_IMPORTANT);
        noteModel.setEditingDate(new Date());
        addNoteUseCase.addNewNote(noteModel);
        view.showPreviousPage();
    }

    public void onDiscardRequested() {
        view.showPreviousPage();
    }
}
