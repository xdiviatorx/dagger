package com.usage.dagger.daggerusage.android.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.usage.dagger.daggerusage.R;
import com.usage.dagger.daggerusage.domain.models.NotePriority;

public class PriorityText extends AppCompatTextView {
    public PriorityText(Context context) {
        super(context);
    }

    public PriorityText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PriorityText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPriority(NotePriority priority) {
        switch (priority) {
            case URGENT_AND_IMPORTANT:
                setTextColor(ContextCompat.getColor(getContext(), R.color.red_700));
                setText(R.string.urgent_and_important);
                break;
            case IMPORTANT_NOT_URGENT:
                setTextColor(ContextCompat.getColor(getContext(), R.color.orange_700));
                setText(R.string.important_not_urgent);
                break;
            case URGENT_NOT_IMPORTANT:
                setTextColor(ContextCompat.getColor(getContext(), R.color.amber_600));
                setText(R.string.urgent_not_important);
                break;
            case NOT_URGENT_NOT_IMPORTANT:
                setTextColor(ContextCompat.getColor(getContext(), R.color.green_400));
                setText(R.string.not_urgent_not_important);
                break;
        }
    }
}
