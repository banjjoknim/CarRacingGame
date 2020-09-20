import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperationTest {
    private Operation operation = new Operation();

    @ParameterizedTest
    @ValueSource(strings = {"hi,hello", "hello,check", "    ok,          go          ", "          ", ""})
    void inputNamesTest(String names) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(names.getBytes());
        System.setIn(byteArrayInputStream);
        Scanner scanner = new Scanner(System.in);
        if ("".equals(names.trim())) {
            assertThat(names).isBlank();
            return;
        }

        assertThat(scanner.nextLine()).isEqualTo(names); // inputNames() 메소드의 바디 => scanner.nextLine()
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "5:5", "4:4", "3:3", "7:7"}, delimiter = ':')
    void inputMoveTimesTest(String inputNumber, String expectedNumber) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputNumber.getBytes());
        System.setIn(byteArrayInputStream);
        Scanner scanner = new Scanner(System.in);
        Integer actual = Integer.valueOf(scanner.nextLine()); // inputMoveTimes() 메소드의 바디 => scanner.nextInt()
        Integer expected = Integer.valueOf(expectedNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi,hello", "hello,check", "ok,go"})
    void setCarsTest(String names) { // Car객체의 참조값이 다름. 따라서 실제 값을 비교하였음. todo : 왜 참조값이 다를까?
        List<Car> cars = new ArrayList<>();
        List<Car> carsForTest = operation.setCars(names);
        for (int i = 0; i < names.split(",").length; i++) {
            Car car = new Car(names.split(",")[i]);
            cars.add(car);
        }

        assertThat(cars.size()).isEqualTo(carsForTest.size());

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Car carFromSetCars = carsForTest.get(i);

            assertThat(car.getName()).isEqualTo(carFromSetCars.getName());
            assertThat(car.getPosition()).isEqualTo(carFromSetCars.getPosition());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi,hello,hell,ok", "hoho,hi,woghd,kkkk"})
    void initTest(String names) {
        List<Car> cars = new ArrayList<>();
        Map<Car, Integer> carInfos = new HashMap<>();
        Arrays.stream(names.split(","))
            .map(Car::new)
            .forEach(car -> cars.add(car));
        for (int i = 0; i < cars.size(); i++) {
            carInfos.put(cars.get(i), cars.get(i).getPosition());
        }

        assertThat(operation.init(cars)).isEqualTo(carInfos);
    }

    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3:0,3,5:5", "hi!,hello,hong:1,5,2:5",
        "ho,her,hell,sky,blue:0,2,6,8,5:8"}, delimiter = ':')
    void getMaxPositionTest(String names, String position, String expectedMaxPosition) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = names.split(",");
        String[] positions = position.split(",");
        Map<Car, Integer> carInfos = new HashMap<>();

        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            cars.add(car);
            carInfos.put(car, Integer.valueOf(positions[i]));
        }
        int maxPosition = operation.getMaxPosition(cars, carInfos);

        assertThat(maxPosition).isEqualTo(Integer.valueOf(expectedMaxPosition));
    }

    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3:0,5,5:5:car2, car3", "hi!,hello,hong:5,5,2:5:hi!, hello",
        "ho,her,hell,sky,blue:0,8,6,8,5:8:her, sky"}, delimiter = ':')
    void getWinnderNamesTest(String names, String position, String maxPosition, String expectedWinners) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = names.split(",");
        String[] positions = position.split(",");
        Map<Car, Integer> carInfos = new HashMap<>();

        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            cars.add(car);
            carInfos.put(car, Integer.valueOf(positions[i]));
        }
        String winners = operation.getWinnerNames(cars, carInfos, Integer.valueOf(maxPosition));
        assertThat(winners).isEqualTo(expectedWinners);
    }
}
