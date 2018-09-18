package com.usage.dagger.daggerusage.di.modules;

import android.view.LayoutInflater;

import com.usage.dagger.daggerusage.android.activities.MainActivity;
import com.usage.dagger.daggerusage.android.adapters.NoteListRecyclerAdapter;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListActivityModule {

    @Provides
    public NoteListPresenter provideNoteListPresenter(MainActivity mainActivity, GetNotesListUseCase useCase) {
        return new NoteListPresenter(mainActivity, useCase);
    }

    @Provides
    public NoteListRecyclerAdapter provideNoteListRecyclerAdapter(LayoutInflater inflater) {
        return new NoteListRecyclerAdapter(inflater);
    }
}
