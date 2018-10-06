package com.usage.dagger.daggerusage.presentation.views;

import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.util.List;

public interface NoteListView {

    void removeDataFromList();

    void showNewNotesPage(List<NoteModel> notes);

    void showError();

    void showCreateNoteScreen();
}
