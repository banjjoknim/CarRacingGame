package model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest extends Car {
    private static final int DRIVE_POSITION = 1;

    public CarTest(String name) {
        super(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {" asdsd", " sjd", "651   "})
    void isCorrectNameTest(String input) {
        Car car = new Car(input);
        assertThat(car.isCorrectName()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "         ", "alskdmas  ", "  123456"})
    void isNotCorrectNameTest(String input) {
        Car car = new Car(input);
        assertThat(car.isCorrectName()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "aslkd   "})
    void setUpCarsTest(String input) {
        List<Car> cars = new ArrayList<>();
        Car car = new Car(input);
        car.setUpCars(cars);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(input.trim());
        }
    }

    @Test
    void createConditionValueTest() {
        Car car = new Car("test");
        int conditionValue = car.createConditionValue();
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
