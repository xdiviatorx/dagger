package com.usage.dagger.daggerusage.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.android.App;
import com.usage.dagger.daggerusage.presentation.contracts.NoteCreateContract;
import com.usage.dagger.daggerusage.presentation.contracts.NoteModifyContract;
import com.usage.dagger.daggerusage.presentation.presenters.NoteCreatePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class NoteCreateActivity extends NoteModifyActivity implements NoteCreateContract.View {

    @Inject NoteCreatePresenter presenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NoteCreateActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
        App.getApp().getAppComponent().inject(this);
    }

    @Inject
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_add, menu);
        return true;
    }

    @Override
    public NoteModifyContract.Presenter getPresenter() {
        return presenter;
    }
}
