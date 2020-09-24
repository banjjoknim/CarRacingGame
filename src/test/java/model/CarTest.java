package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("적절한 이름 테스트")
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

    @DisplayName("부적절한 이름 테스트")
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

    @DisplayName("Car객체와 입력된 이름과의 일치 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void getNameTest(String input) {
        Car car = new Car(input);
        assertThat(car.getName()).isEqualTo(input);
    }

    @DisplayName("Car객체와 초기화된 position 일치 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void getPositionTest(String input) {
        Car car = new Car(input);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("전진 또는 정지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void driveTest(String input) {
        Car car = new Car(input);
        car.drive();
        assertThat(car.getPosition()).isBetween(0, 1);
    }

}
