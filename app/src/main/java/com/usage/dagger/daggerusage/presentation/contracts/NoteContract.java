package com.usage.dagger.daggerusage.presentation.contracts;

public interface NoteContract {

    interface View extends BaseContract.View {
        void setTitle(String title);

        void setNoteText(String text);

        void showPreviousPage();
    }

    interface Presenter<V> extends BaseContract.Presenter<V> {

    }
}
