package com.usage.dagger.daggerusage.di.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;

import com.usage.dagger.daggerusage.android.adapters.NoteListRecyclerAdapter;
import com.usage.dagger.daggerusage.android.listeners.RecyclerLinearScrollListener;
import com.usage.dagger.daggerusage.domain.Const;
import com.usage.dagger.daggerusage.domain.entities.Pagination;
import com.usage.dagger.daggerusage.domain.entities.TypeSortedNotesRetriever;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListScreenModule {

    @Provides
    @Singleton
    public TypeSortedNotesRetriever provideTypeSortedNoteListRetriever(INoteRepository noteRepository) {
        return new TypeSortedNotesRetriever(noteRepository, NoteSortType.CUSTOM);
    }

    @Provides
    @Singleton
    public GetNotesListUseCase provideGetNoteListUseCase(TypeSortedNotesRetriever notesRetriever,
                                                         Pagination<NoteModel> pagination) {
        return new GetNotesListUseCase(notesRetriever, pagination);
    }

    @Provides
    @Singleton
    public Pagination<NoteModel> provideNotePagination() {
        return new Pagination<>(Const.NOTE_PAGE_SIZE);
    }

    @Provides
    @Singleton
    public NoteListPresenter provideNoteListPresenter(GetNotesListUseCase useCase) {
        return new NoteListPresenter(useCase);
    }

    @Provides
    public DateFormat provideDateFormat() {
        return new SimpleDateFormat(Const.DATE_FORMAT_PATTERN, Locale.getDefault());
    }

    @Provides
    @Singleton
    public NoteListRecyclerAdapter provideNoteListRecyclerAdapter(LayoutInflater inflater, DateFormat dateFormat) {
        return new NoteListRecyclerAdapter(inflater, dateFormat);
    }

    @Provides
    @Singleton
    public LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    @Singleton
    public RecyclerLinearScrollListener provideRecyclerScrollListener(LinearLayoutManager layoutManager,
                                                                      NoteListPresenter presenter) {
        return new RecyclerLinearScrollListener(layoutManager, presenter, Const.NOTE_PAGE_PAGINATION_THRESHOLD);
    }
}
