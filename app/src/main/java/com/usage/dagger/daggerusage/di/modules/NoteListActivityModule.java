package com.usage.dagger.daggerusage.di.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;

import com.usage.dagger.daggerusage.android.adapters.NoteListRecyclerAdapter;
import com.usage.dagger.daggerusage.android.listeners.RecyclerLinearScrollListener;
import com.usage.dagger.daggerusage.domain.Const;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListActivityModule {

    @Provides
    @Singleton
    public NoteListPresenter provideNoteListPresenter(GetNotesListUseCase useCase) {
        return new NoteListPresenter(useCase);
    }

    @Provides
    @Singleton
    public NoteListRecyclerAdapter provideNoteListRecyclerAdapter(LayoutInflater inflater) {
        return new NoteListRecyclerAdapter(inflater);
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
