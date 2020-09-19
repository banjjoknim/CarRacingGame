public class Condition {
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;
    private static final int CONDITION_GOOD_MIN_VALUE = 4;
    private static final boolean GOOD = true;
    private static final boolean BAD = false;

    private int createConditionValue() {
        int conditionValue = (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
        return conditionValue;
    }

    public boolean isGood() {
        int conditionValue = createConditionValue();
        if (conditionValue >= CONDITION_GOOD_MIN_VALUE) {
            return GOOD;
        }
        return BAD;
    }
}
