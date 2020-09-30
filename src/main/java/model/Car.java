package model;

public class Car {
    private static final int DRIVE_POSITION = 1;
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;
    private static final int CONDITION_GOOD_MIN_VALUE = 4;
    private static final boolean GOOD = true;
    private static final boolean BAD = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private static final String NOT_SUITABLE_INPUT = "부적합한 입력입니다.";
    private static final String CAR_POSITION_VIEW = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(isCorrectName(name));
        this.name = name;
    }

    private void validateName(boolean isCorrectName) {
        if (!isCorrectName) {
            throw new IllegalArgumentException(NOT_SUITABLE_INPUT);
        }
    }

    private boolean isCorrectName(String name) {
        return isNotBlank(name) && isLengthIsBelowCorrectNameLengthLimit(name);
    }

    private boolean isNotBlank(String name) {
        return !name.contains(" ");
    }

    private boolean isLengthIsBelowCorrectNameLengthLimit(String name) {
        return name.length() <= CORRECT_NAME_LENGTH_LIMIT;
    }

    public String getName() {
        return new Car(name).name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionView(int position) {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += CAR_POSITION_VIEW;
        }
        return positionView;
    }

    public void drive(int conditionValue) {
        if (isGood(conditionValue)) {
            this.position = this.position + DRIVE_POSITION;
        }
    }

    public int getConditionValue() {
        return (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
    }

    private boolean isGood(int conditionValue) {
        if (conditionValue >= CONDITION_GOOD_MIN_VALUE) {
            return GOOD;
        }
        return BAD;
    }

}
