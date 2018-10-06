package com.usage.dagger.daggerusage.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.android.App;
import com.usage.dagger.daggerusage.android.adapters.NoteListRecyclerAdapter;
import com.usage.dagger.daggerusage.android.listeners.RecyclerLinearScrollListener;
import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.presentation.presenters.NoteListPresenter;
import com.usage.dagger.daggerusage.presentation.views.NoteListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NoteListView {

    @Inject NoteListPresenter presenter;
    @Inject NoteListRecyclerAdapter adapter;
    @Inject LinearLayoutManager layoutManager;
    @Inject RecyclerLinearScrollListener scrollListener;

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getApp().getAppComponent().inject(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        presenter.onNewPageNeeded();
    }

    @Inject
    public void attachViewToPresenter() {
        presenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.custom_sort:
                presenter.onCustomSortSelected();
                return true;
            case R.id.priority_sort:
                presenter.onPrioritySortSelected();
                return true;
            case R.id.editing_date_sort:
                presenter.onEditingDateSortSelected();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void removeDataFromList() {
        adapter.clearNotes();
    }

    @Override
    public void showNewNotesPage(List<NoteModel> notes) {
        adapter.addNotes(notes);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "WTF!!!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAddNoteScreen() {
        startActivity(NoteCreateActivity.newIntent(getApplicationContext()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerView.removeOnScrollListener(scrollListener);
    }

    @OnClick(R.id.add_note_button)
    public void onAddNoteButtonClick() {
        presenter.onAddButtonClicked();
    }
}
