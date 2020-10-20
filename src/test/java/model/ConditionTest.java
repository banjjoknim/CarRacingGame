package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConditionTest {

    @DisplayName("Condition 객체의 랜덤한 ConditionValue 유효성 테스트")
    @Test
    void newConditionTest() {
        assertThat(Condition.getConditionValue())
            .isBetween(0, 9);
    }
}
