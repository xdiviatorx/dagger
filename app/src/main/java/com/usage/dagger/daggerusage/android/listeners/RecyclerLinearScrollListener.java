package com.usage.dagger.daggerusage.android.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.usage.dagger.daggerusage.presentation.presenters.PaginationPresenter;

public class RecyclerLinearScrollListener extends RecyclerView.OnScrollListener {

    private final LinearLayoutManager layoutManager;
    private final PaginationPresenter presenter;
    private final int paginationThreshold;

    public RecyclerLinearScrollListener(LinearLayoutManager layoutManager, PaginationPresenter presenter,
                                        int paginationThreshold) {
        this.layoutManager = layoutManager;
        this.presenter = presenter;
        this.paginationThreshold = paginationThreshold;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (layoutManager.findFirstVisibleItemPosition() + layoutManager.getChildCount() >=
                layoutManager.getItemCount() - paginationThreshold) {
            presenter.onNewPageNeeded();
        }
    }
}
