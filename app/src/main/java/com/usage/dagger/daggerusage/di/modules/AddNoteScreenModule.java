package com.usage.dagger.daggerusage.di.modules;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;
import com.usage.dagger.daggerusage.domain.usecase.AddNoteUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.AddNotePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AddNoteScreenModule {

    @Provides
    public AddNotePresenter provideAddNotePresenter(AddNoteUseCase addNoteUseCase, NoteModel noteModel) {
        return new AddNotePresenter(addNoteUseCase, noteModel);
    }

    @Provides
    public NoteModel provideNewNoteModel() {
        return new NoteModel();
    }

    @Provides
    @Singleton
    public AddNoteUseCase provideAddNoteUseCase(INoteRepository noteRepository) {
        return new AddNoteUseCase(noteRepository);
    }
}
