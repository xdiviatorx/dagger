package com.usage.dagger.daggerusage.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    protected void onStop() {
        super.onStop();
        recyclerView.removeOnScrollListener(scrollListener);
    }
}
