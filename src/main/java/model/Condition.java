package model;

public class Condition {
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;

    private int conditionValue;

    public Condition() {
        this.conditionValue = (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
    }

    public int getConditionValue() {
        return new Condition().conditionValue;
    }
}
