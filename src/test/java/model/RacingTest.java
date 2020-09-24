package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {
    Racing racing = new Racing();

    @DisplayName("경주에 참가할 자동차 세팅 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"als,qweop,skld", "car1,car2,car3"})
    void setCarsTest(String input) {
        List<Car> cars = racing.setCars(input);
        String settedCars = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
        assertThat(settedCars).isEqualTo(input);
    }

    @DisplayName("자동차 게임 진행 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2", "carr1,carr2"})
    void raceTest(String input) {
        List<Car> cars = racing.setCars(input);
        racing.race(cars);
    }

    @DisplayName("자동차 게임 우승자 이름 얻기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3:car1, car2, car3"}, delimiter = ':')
    void getWinnersTest(String input, String winners) {
        List<Car> cars = Arrays.stream(input.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
        assertThat(racing.getWinners(cars)).isEqualTo(winners);
    }
}
