package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("적절한 이름의 객체 생성 및 초기화된 상태값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdsd", "sjd", "651"})
    void isCorrectNameTest(String input) {
        assertThatCode(() -> new Car(input))
            .doesNotThrowAnyException();
        assertThat(new Car(input).getName()).isEqualTo(input);
        assertThat(new Car(input).getPosition()).isEqualTo(0);
    }

    @DisplayName("부적절한 이름의 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "al  ", "123456"})
    void isNotCorrectNameTest(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car(input))
            .withMessage("부적합한 입력입니다.")
            .withMessageContaining("부적합")
            .withNoCause();
    }

    @DisplayName("전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void driveTest(int input) {
        Car car = new Car("test");
        car.drive(input);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int input) {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
