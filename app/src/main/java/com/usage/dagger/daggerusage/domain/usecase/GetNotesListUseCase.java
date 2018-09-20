package com.usage.dagger.daggerusage.domain.usecase;

import com.usage.dagger.daggerusage.domain.entities.Pagination;
import com.usage.dagger.daggerusage.domain.entities.TypeSortedNotesRetriever;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;

import java.util.List;

public class GetNotesListUseCase {

    private final TypeSortedNotesRetriever notesRetriever;
    private final Pagination<NoteModel> pagination;

    public GetNotesListUseCase(TypeSortedNotesRetriever notesRetriever, Pagination<NoteModel> pagination) {
        this.notesRetriever = notesRetriever;
        this.pagination = pagination;
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
        if (notesRetriever.changeSortType(noteSortType)) {
            pagination.flush();
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
        List<NoteModel> page = notesRetriever.getPage(pagination.offset(), pagination.count());
        pagination.update(page);
        return page;
    }

    public interface Callback {
        void onFirstPageRetrieved(List<NoteModel> notes);

        void onNewPageRetrieved(List<NoteModel> notes);

        void onRetrieveNewPageFailed(Exception e);
    }
}
