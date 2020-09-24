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

    @DisplayName("경주에 참가할 자동차 세팅 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"als,qweop,skld", "car1,car2,car3"})
    void newRacingTest(String input) {
        Racing racing = new Racing(input);
        String racingCars = racing.getCars().stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));

        List<Car> cars = Arrays.stream(input.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
        String settedCars = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));

        assertThat(racingCars).isEqualTo(settedCars);
    }

    @DisplayName("자동차 게임 진행 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2:5", "carr1,carr2:3"}, delimiter = ':')
    void raceTest(String input, String inputMoveTimes) {
        Racing racing = new Racing(input);
        int moveTimes = Integer.valueOf(inputMoveTimes);
        for (int i = 0; i < moveTimes; i++) {
            racing.race();
        }
        assertThat(
            racing.getCars().stream()
                .map(Car::getPosition)
                .allMatch(position -> 0 <= position && position <= moveTimes))
            .isTrue();
    }

    @DisplayName("자동차 게임 우승자 이름 얻기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3:car1, car2, car3"}, delimiter = ':')
    void getWinnersTest(String input, String winners) {
        Racing racing = new Racing(input);
        assertThat(racing.getWinners()).isEqualTo(winners);
    }
}
