package com.usage.dagger.daggerusage.presentation.presenters;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.presentation.contracts.NoteModifyContract;

public abstract class NoteModifyPresenter<View extends NoteModifyContract.View>
        implements NoteModifyContract.Presenter<View> {

    private NoteModel noteModel;

    NoteModifyPresenter(NoteModel noteModel) {
        this.noteModel = noteModel;
    }

    @Override
    public void onNoteTitleChanged(String title) {
        noteModel.setTitle(title);
    }

    @Override
    public void onNoteTextChanged(String text) {
        noteModel.setText(text);
    }

    @Override
    public void onDiscardRequested() {
        getView().showPreviousPage();
    }

    protected abstract View getView();
}
