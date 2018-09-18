package com.usage.dagger.daggerusage.domain.entities;

import java.util.List;

public class Pagination<Model> {

    private int pageSize;

    private int offset;

    public Pagination(int pageSize) {
        this.pageSize = pageSize;
        this.offset = 0;
    }

    public int getOffset() {
        return offset;
    }

    public int getCount() {
        return pageSize;
    }

    public void updateOffset(List<Model> page) {
        this.offset += page.size();
    }

    public void flushOffset() {
        this.offset = 0;
    }
}
