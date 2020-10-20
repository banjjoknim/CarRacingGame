package model;

public class Car {
    private static final int DRIVE_POSITION = 1;
    private static final int CONDITION_GOOD_MIN_VALUE = 4;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private static final String NOT_SUITABLE_INPUT = "부적합한 입력입니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!isCorrectName(name)) {
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
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void drive(int conditionValue) {
        if (isDriveOrStop(conditionValue)) {
            this.position = this.position + DRIVE_POSITION;
        }
    }

    private boolean isDriveOrStop(int conditionValue) {
        return conditionValue >= CONDITION_GOOD_MIN_VALUE;
    }

    public boolean isMaxPosition(int maxPosition) {
        return maxPosition == position;
    }
}
