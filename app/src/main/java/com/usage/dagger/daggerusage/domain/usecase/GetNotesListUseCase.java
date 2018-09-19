package com.usage.dagger.daggerusage.domain.usecase;

import com.usage.dagger.daggerusage.domain.entities.Pagination;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

import java.util.List;

public class GetNotesListUseCase {

    private final INoteRepository noteRepository;
    private final Pagination<NoteModel> pagination;
    private NoteSortType noteSortType;

    public GetNotesListUseCase(INoteRepository noteRepository, Pagination<NoteModel> pagination,
                               NoteSortType defaultSortType) {
        this.noteRepository = noteRepository;
        this.pagination = pagination;
        this.noteSortType = defaultSortType;
    }

    public void requestNewPage(Callback callback) {
        try {
            List<NoteModel> newPage = getNewPage();
            if (newPage.size() != 0) {
                callback.onNewPageRetrieved(newPage);
            }
        } catch (Exception e) {
            callback.onRetrieveNewPageFailed(e);
        }
    }

    public void onSortTypeChanged(NoteSortType noteSortType, Callback callback) {
        if (!this.noteSortType.equals(noteSortType)) {
            this.noteSortType = noteSortType;
            pagination.flushOffset();
            try {
                List<NoteModel> newPage = getNewPage();
                if (newPage.size() != 0) {
                    callback.onFirstPageRetrieved(newPage);
                }
            } catch (Exception e) {
                callback.onRetrieveNewPageFailed(e);
            }
        }
    }

    private List<NoteModel> getNewPage() {
        List<NoteModel> page = noteRepository.getCustomOrder(pagination.getOffset(), pagination.getCount());
        switch (noteSortType) {
            case DATE:
                page = noteRepository.getOrderedByEditingDate(pagination.getOffset(), pagination.getCount());
                break;
            case PRIORITY:
                page = noteRepository.getOrderedByPriority(pagination.getOffset(), pagination.getCount());
                break;
            case CUSTOM:
                page = noteRepository.getCustomOrder(pagination.getOffset(), pagination.getCount());
                break;
        }
        pagination.updateOffset(page);
        return page;
    }

    public interface Callback {
        void onFirstPageRetrieved(List<NoteModel> notes);

        void onNewPageRetrieved(List<NoteModel> notes);

        void onRetrieveNewPageFailed(Exception e);
    }
}
