package com.usage.dagger.daggerusage.presentation.contracts;

public interface NoteCreateContract {

    interface View extends NoteModifyContract.View {

    }

    interface Presenter extends NoteModifyContract.Presenter<View> {

    }
}
