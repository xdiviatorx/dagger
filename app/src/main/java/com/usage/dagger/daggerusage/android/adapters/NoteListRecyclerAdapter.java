package com.usage.dagger.daggerusage.android.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteListRecyclerAdapter extends RecyclerView.Adapter<NoteListRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;

    private List<NoteModel> notes;

    public NoteListRecyclerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    public void clearNotes() {
        notes.clear();
    }

    public void addNotes(List<NoteModel> notes) {
        this.notes.addAll(notes);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title) TextView title;
        @BindView(R.id.note) TextView note;
        @BindView(R.id.priority) TextView priority;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(NoteModel noteModel) {
            title.setText(noteModel.getTitle());
            note.setText(noteModel.getText());
            priority.setText(String.valueOf(noteModel.getPriority()));
        }
    }
}
