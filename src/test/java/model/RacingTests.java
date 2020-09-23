package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {
    Racing racing = new Racing();

    @DisplayName("자동차 게임 진행 출력")
    @ParameterizedTest
    @ValueSource(strings = {"car1, car2", "carr1, carr2"})
    void raceTest(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
        racing.race(cars);
    }
}
