package com.usage.dagger.daggerusage.domain.entities;

import java.util.List;

public class Pagination<Model> {

    private int pageSize;

    private int offset;

    public Pagination(int pageSize) {
        this.pageSize = pageSize;
        this.offset = 0;
    }

    public int offset() {
        return offset;
    }

    public int count() {
        return pageSize;
    }

    public void update(List<Model> page) {
        this.offset += page.size();
    }

    public void flush() {
        this.offset = 0;
    }
}
