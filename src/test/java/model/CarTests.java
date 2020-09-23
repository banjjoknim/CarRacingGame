package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private static final int DRIVE_POSITION = 1;

    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void isCorrectNameTest(String input) {
        Car car = new Car(input);
        assertThat(car.isCorrectName(car.getName())).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "         ", "alskdmas  ", "  123456"})
    void isNotCorrectNameTest(String input) {
        Car car = new Car(input);
        System.out.println(car.getName());
        assertThat(car.getName()).isNull();
        // assertThat(car.isCorrectName(car.getName())).isFalse();
    }

    @Test
    void createConditionValueTest() {
        Car car = new Car("test");
        int conditionValue = car.getConditionValue();
        assertThat(conditionValue).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"asdsd,4", "asdsd,5", "asdsd,6", "asdsd,7", "asdsd,8", "asdsd,9"})
    void driveTest(String input, String conditionValue) {
        Car car = new Car(input);
        car.drive(Integer.valueOf(conditionValue));
        assertThat(car.getPosition()).isEqualTo(DRIVE_POSITION);
    }

    @ParameterizedTest
    @CsvSource(value = {"asdsd,0", "asdsd,1", "asdsd,2", "asdsd,3"})
    void stopTest(String input, String conditionValue) {
        Car car = new Car(input);
        car.drive(Integer.valueOf(conditionValue));
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
