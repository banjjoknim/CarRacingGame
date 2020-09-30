package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
    private static final int INITIAL_POSITION = 0;

    private List<Car> setUpTestCars(String input) { // 테스트를 위한 Cars 설정
        return Arrays.stream(input.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    @DisplayName("Cars 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"als,qweop,skld", "car1,car2,car3"})
    void newCarsTest(String input) {
        List<Car> cars = setUpTestCars(input);
        assertThatCode(() -> new Cars(cars)).doesNotThrowAnyException();
        assertThat(new Cars(cars).getCars()).isEqualTo(cars);
    }

    @DisplayName("경주 진행중 Car객체가 갖는 position값 유효성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2:5", "carr1,carr2:3"}, delimiter = ':')
    void raceTest(String input, String inputMoveTimes) {
        List<Car> testCars = setUpTestCars(input);
        Cars cars = new Cars(testCars);
        int moveTimes = Integer.valueOf(inputMoveTimes);
        for (int i = 0; i < moveTimes; i++) {
            cars.race();
        }
        assertThat(cars.getCars())
            .extracting(Car::getPosition)
            .allMatch(position -> validatePosition(position, moveTimes));

    }

    private boolean validatePosition(int position, int moveTimes) {
        return INITIAL_POSITION <= position && position <= moveTimes;
    }

    @DisplayName("자동차 게임 우승자 이름 얻기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3:car1, car2, car3"}, delimiter = ':')
    void getWinnersTest(String input, String winners) {
        Cars cars = new Cars(setUpTestCars(input));
        assertThat(cars.getWinners()).isEqualTo(winners);
    }
}
