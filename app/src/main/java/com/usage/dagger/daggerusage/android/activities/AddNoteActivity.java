package com.usage.dagger.daggerusage.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.android.App;
import com.usage.dagger.daggerusage.presentation.presenters.AddNotePresenter;
import com.usage.dagger.daggerusage.presentation.views.AddNoteView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class AddNoteActivity extends AppCompatActivity implements AddNoteView {

    @Inject AddNotePresenter presenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                presenter.onSaveRequested();
                return true;
            case android.R.id.home:
                presenter.onDiscardRequested();
                return true;
        }
        return false;
    }

    @OnTextChanged(R.id.note_title_input)
    public void onNoteTitleChanged(CharSequence text) {
        presenter.onNoteTitleChanged(text.toString());
    }

    @OnTextChanged(R.id.note_text_input)
    public void onNoteTextChanged(CharSequence text) {
        presenter.onNoteTextChanged(text.toString());
    }

    @Override
    public void showPreviousPage() {
        finish();
    }
}
