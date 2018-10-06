package com.usage.dagger.daggerusage.presentation.presenters;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.views.NoteListView;

import java.util.List;

public class NoteListPresenter implements GetNotesListUseCase.Callback, PaginationPresenter {

    private NoteListView view;
    private GetNotesListUseCase getNotesListUseCase;

    public NoteListPresenter(GetNotesListUseCase getNotesListUseCase) {
        this.getNotesListUseCase = getNotesListUseCase;
    }

    public void attachView(NoteListView view) {
        this.view = view;
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

    @Override
    public void onNewPageNeeded() {
        getNotesListUseCase.requestNewPage(this);
    }

    @Override
    public void onFirstPageRetrieved(List<NoteModel> notes) {
        view.removeDataFromList();
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

    public void onAddButtonClicked() {
        view.showAddNoteScreen();
    }
}
