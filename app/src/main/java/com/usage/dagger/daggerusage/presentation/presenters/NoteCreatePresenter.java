package com.usage.dagger.daggerusage.presentation.presenters;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NotePriority;
import com.usage.dagger.daggerusage.domain.usecase.AddNoteUseCase;
import com.usage.dagger.daggerusage.presentation.contracts.NoteCreateContract;

import java.util.Date;

public class NoteCreatePresenter extends NoteModifyPresenter<NoteCreateContract.View>
        implements NoteCreateContract.Presenter {

    private final AddNoteUseCase addNoteUseCase;
    private NoteModel noteModel;
    private NoteCreateContract.View view;

    public NoteCreatePresenter(AddNoteUseCase addNoteUseCase, NoteModel noteModel) {
        super(noteModel);
        this.addNoteUseCase = addNoteUseCase;
        this.noteModel = noteModel;
    }

    @Override
    public void onSaveRequested() {
        noteModel.setPriority(NotePriority.URGENT_AND_IMPORTANT);
        noteModel.setEditingDate(new Date());
        addNoteUseCase.addNewNote(noteModel);
        view.showPreviousPage();
    }

    public void attachView(NoteCreateContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    protected NoteCreateContract.View getView() {
        return view;
    }
}
