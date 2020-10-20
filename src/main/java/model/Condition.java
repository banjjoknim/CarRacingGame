package model;

public class Condition {
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;

    public static int getConditionValue() {
        return (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
    }
}
