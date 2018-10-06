package com.usage.dagger.daggerusage.presentation.contracts;

public interface NoteModifyContract {

    interface View extends NoteContract.View {

    }

    interface Presenter<V> extends NoteContract.Presenter<V> {
        void onNoteTitleChanged(String title);

        void onNoteTextChanged(String text);

        void onSaveRequested();

        void onDiscardRequested();
    }
}
