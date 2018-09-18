package com.usage.dagger.daggerusage.di.modules;

import com.usage.dagger.daggerusage.domain.Const;
import com.usage.dagger.daggerusage.domain.entities.Pagination;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;
import com.usage.dagger.daggerusage.domain.usecase.GetNotesListUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteModule {

    @Provides
    public GetNotesListUseCase provideGetNoteListUseCase(INoteRepository noteRepository,
                                                         Pagination<NoteModel> pagination) {
        return new GetNotesListUseCase(noteRepository, pagination, NoteSortType.CUSTOM);
    }

    @Provides
    public Pagination<NoteModel> provideNotePagination() {
        return new Pagination<>(Const.NOTE_PAGE_SIZE);
    }
}
