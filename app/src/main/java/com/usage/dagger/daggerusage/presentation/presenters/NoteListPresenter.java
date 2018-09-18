package com.usage.dagger.daggerusage.presentation.presenters;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.views.NoteListView;

import java.util.List;

public class NoteListPresenter implements GetNotesListUseCase.Callback {

    private NoteListView view;
    private GetNotesListUseCase getNotesListUseCase;

    public NoteListPresenter(NoteListView view, GetNotesListUseCase getNotesListUseCase) {
        this.view = view;
        this.getNotesListUseCase = getNotesListUseCase;
    }

    public void onCustomSortSelected() {
        getNotesListUseCase.onSortTypeChanged(NoteSortType.CUSTOM, this);
    }

    public void onPrioritySortSelected() {
        getNotesListUseCase.onSortTypeChanged(NoteSortType.PRIORITY, this);
    }

    public void onEditingDateSortSelected() {
        getNotesListUseCase.onSortTypeChanged(NoteSortType.DATE, this);
    }

    public void onNewPageRequested() {
        getNotesListUseCase.requestNewPage(this);
    }

    @Override
    public void onFirstPageRetrieved(List<NoteModel> notes) {
        view.clearList();
        view.showNewNotesPage(notes);
    }

    @Override
    public void onNewPageRetrieved(List<NoteModel> notes) {
        view.showNewNotesPage(notes);
    }

    @Override
    public void onRetrieveNewPageFailed(Exception e) {
        view.showError();
    }
}
