package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void isCorrectNameTest(String input) {
        Car car = null;
        try {
            car = new Car(input);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
        assertThat(car.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "         ", "alskdmas  ", "  123456"})
    void isNotCorrectNameTest(String input) {
        Car car = null;
        try {
            car = new Car(input);
        } catch (Exception e) {
            assertThat(car).isNull();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void getNameTest(String input) {
        Car car = new Car(input);
        assertThat(car.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void driveTest(String input) {
        Car car = new Car(input);
        car.drive();
        assertThat(car.getPosition()).isBetween(0, 1);
    }

}
