package com.usage.dagger.daggerusage.presentation.views;

import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.util.List;

public interface NoteListView {

    void clearList();

    void showNewNotesPage(List<NoteModel> notes);

    void showError();
}
