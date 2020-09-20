import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConditionTest {
    private Condition condition = new Condition();

    @Test
    void createConditionValueTest() {
        int conditionValue = condition.createConditionValue();
        assertThat(conditionValue).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isGoodIsFalseTest(int conditionValue) {
        assertThat(condition.isGood(conditionValue)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isGoodIsTrueTest(int conditionValue) {
        assertThat(condition.isGood(conditionValue)).isTrue();
    }
}
