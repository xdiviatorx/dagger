package com.usage.dagger.daggerusage.domain.models;

public enum NotePriority {

    URGENT_AND_IMPORTANT(1),
    IMPORTANT_NOT_URGENT(2),
    URGENT_NOT_IMPORTANT(3),
    NOT_URGENT_NOT_IMPORTANT(4);

    private int intValue;

    NotePriority(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public static NotePriority valueOf(int priority) {
        switch (priority) {
            case 1:
                return URGENT_AND_IMPORTANT;
            case 2:
                return IMPORTANT_NOT_URGENT;
            case 3:
                return URGENT_NOT_IMPORTANT;
            case 4:
                return NOT_URGENT_NOT_IMPORTANT;
            default:
                return NOT_URGENT_NOT_IMPORTANT;
        }
    }
}
