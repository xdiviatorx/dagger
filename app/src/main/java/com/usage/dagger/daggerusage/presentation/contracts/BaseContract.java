package com.usage.dagger.daggerusage.presentation.contracts;

public interface BaseContract {

    interface View {

    }

    interface Presenter<V> {
        void attachView(V view);

        void detachView();
    }
}
