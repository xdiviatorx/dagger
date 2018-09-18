package com.usage.dagger.daggerusage.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.android.App;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;
import com.usage.dagger.daggerusage.presentation.views.NoteListView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements NoteListView {

    @Inject
    NoteListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getApp().getAppComponent().inject(this);
    }

    @Override
    public void clearList() {

    }

    @Override
    public void showNewNotesPage(List<NoteModel> notes) {

    }

    @Override
    public void showError() {

    }
}
