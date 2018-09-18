package com.usage.dagger.daggerusage.di.modules;

import android.view.LayoutInflater;

import com.usage.dagger.daggerusage.android.adapters.NoteListRecyclerAdapter;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListActivityModule {

    @Provides
    public NoteListPresenter provideNoteListPresenter(GetNotesListUseCase useCase) {
        return new NoteListPresenter(useCase);
    }

    @Provides
    public NoteListRecyclerAdapter provideNoteListRecyclerAdapter(LayoutInflater inflater) {
        return new NoteListRecyclerAdapter(inflater);
    }
}
