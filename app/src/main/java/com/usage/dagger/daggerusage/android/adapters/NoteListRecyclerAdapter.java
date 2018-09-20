package com.usage.dagger.daggerusage.android.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.android.widget.PriorityText;
import com.usage.dagger.daggerusage.android.widget.PriorityView;
import com.usage.dagger.daggerusage.domain.models.NoteModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteListRecyclerAdapter extends RecyclerView.Adapter<NoteListRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private DateFormat dateFormat;

    private List<NoteModel> notes;

    public NoteListRecyclerAdapter(LayoutInflater inflater, DateFormat dateFormat) {
        this.inflater = inflater;
        this.dateFormat = dateFormat;
        notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_note, parent, false), dateFormat);
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

        private final DateFormat dateFormat;

        @BindView(R.id.title) TextView title;
        @BindView(R.id.note) TextView note;
        @BindView(R.id.priority_text) PriorityText priorityText;
        @BindView(R.id.priority_accent) PriorityView priorityAccent;
        @BindView(R.id.editing_date) TextView editingDate;

        ViewHolder(View itemView, DateFormat dateFormat) {
            super(itemView);
            this.dateFormat = dateFormat;
            ButterKnife.bind(this, itemView);
        }

        void bind(NoteModel noteModel) {
            title.setText(noteModel.getTitle());
            note.setText(noteModel.getText());
            priorityText.setPriority(noteModel.getPriority());
            priorityAccent.setPriority(noteModel.getPriority());
            editingDate.setText(dateFormat.format(noteModel.getEditingDate()));
        }
    }
}
