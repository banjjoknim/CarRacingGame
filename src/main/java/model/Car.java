package model;

public class Car {
    private static final int DRIVE_POSITION = 1;
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;
    private static final int CONDITION_GOOD_MIN_VALUE = 4;
    private static final boolean GOOD = true;
    private static final boolean BAD = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private String name;
    private int position = 0;

    public Car(String name) {
        if (isCorrectName(name)) {
            this.name = name;
            return;
        }
        throw new RuntimeException();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isCorrectName(String name) {
        return isNotBlank(name) && isLengthIsBelowCorrectNameLengthLimit(name);
    }

    private boolean isNotBlank(String name) {
        return !name.trim().isEmpty() && !name.contains(" ");
    }

    private boolean isLengthIsBelowCorrectNameLengthLimit(String name) {
        return name.length() <= CORRECT_NAME_LENGTH_LIMIT;
    }

    public void drive() {
        int conditionValue = getConditionValue();
        if (isGood(conditionValue)) {
            this.position = this.position + DRIVE_POSITION;
        }
    }

    private int getConditionValue() {
        int conditionValue = (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
        return conditionValue;
    }

    private boolean isGood(int conditionValue) {
        if (conditionValue >= CONDITION_GOOD_MIN_VALUE) {
            return GOOD;
        }
        return BAD;
    }

}
