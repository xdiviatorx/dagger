package com.usage.dagger.daggerusage.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.presentation.contracts.NoteModifyContract;

import butterknife.BindView;
import butterknife.OnTextChanged;

public abstract class NoteModifyActivity extends AppCompatActivity implements NoteModifyContract.View {

    @BindView(R.id.note_title_input) EditText noteTitleInput;
    @BindView(R.id.note_text_input) EditText noteTextInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setTitle(String title) {
        noteTitleInput.setText(title);
    }

    @Override
    public void setNoteText(String text) {
        noteTextInput.setText(text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                getPresenter().onSaveRequested();
                return true;
            case android.R.id.home:
                getPresenter().onDiscardRequested();
                return true;
        }
        return false;
    }

    @Override
    public void showPreviousPage() {
        finish();
    }

    @OnTextChanged(R.id.note_title_input)
    public void onNoteTitleChanged(CharSequence text) {
        getPresenter().onNoteTitleChanged(text.toString());
    }

    @OnTextChanged(R.id.note_text_input)
    public void onNoteTextChanged(CharSequence text) {
        getPresenter().onNoteTextChanged(text.toString());
    }

    public abstract NoteModifyContract.Presenter getPresenter();
}
