package com.usage.dagger.daggerusage.android.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.domain.models.NotePriority;

public class PriorityView extends View {
    public PriorityView(Context context) {
        super(context);
    }

    public PriorityView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PriorityView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPriority(NotePriority priority) {
        switch (priority) {
            case URGENT_AND_IMPORTANT:
                setBackgroundResource(R.color.red_700);
                break;
            case IMPORTANT_NOT_URGENT:
                setBackgroundResource(R.color.orange);
                break;
            case URGENT_NOT_IMPORTANT:
                setBackgroundResource(R.color.lime_200);
                break;
            case NOT_URGENT_NOT_IMPORTANT:
                setBackgroundResource(R.color.green_400);
                break;
        }
    }
}
