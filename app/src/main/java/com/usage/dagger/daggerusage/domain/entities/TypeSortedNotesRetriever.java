package com.usage.dagger.daggerusage.domain.entities;

import com.usage.dagger.daggerusage.domain.models.NoteModel;
import com.usage.dagger.daggerusage.domain.models.NoteSortType;
import com.usage.dagger.daggerusage.domain.repository.INoteRepository;

import java.util.List;

public class TypeSortedNotesRetriever {

    private final INoteRepository noteRepository;
    private NoteSortType sortType;

    public TypeSortedNotesRetriever(INoteRepository noteRepository, NoteSortType initialSortType) {
        this.noteRepository = noteRepository;
        this.sortType = initialSortType;
    }

    public boolean changeSortType(NoteSortType sortType) {
        if (this.sortType.equals(sortType)) {
            return false;
        } else {
            this.sortType = sortType;
            return true;
        }
    }

    public List<NoteModel> getPage(int offset, int count) {
        switch (sortType) {
            case DATE:
                return noteRepository.getOrderedByEditingDate(offset, count);
            case PRIORITY:
                return noteRepository.getOrderedByPriority(offset, count);
            case CUSTOM:
                return noteRepository.getCustomOrder(offset, count);
            default:
                return noteRepository.getOrderedByEditingDate(offset, count);
        }
    }
}
