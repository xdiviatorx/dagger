package com.usage.dagger.daggerusage.di.modules;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;
import com.usage.dagger.daggerusage.domain.usecase.AddNoteUseCase;
import com.usage.dagger.daggerusage.presentation.presenters.NoteCreatePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AddNoteScreenModule {

    @Provides
    public NoteCreatePresenter provideAddNotePresenter(AddNoteUseCase addNoteUseCase, NoteModel noteModel) {
        return new NoteCreatePresenter(addNoteUseCase, noteModel);
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
