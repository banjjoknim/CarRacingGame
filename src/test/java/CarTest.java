import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"name:name", "hi:hi", "bye:bye"}, delimiter = ':')
    void getNameTest(String input, String expected) {
        Car car = new Car(input);
        assertThat(car.getName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"name:0", "hi:0", "bye:0"}, delimiter = ':')
    void getPositionTest(String input, String expected) {
        Car car = new Car(input);
        assertThat(car.getPosition()).isEqualTo(Integer.valueOf(expected));
    }
}
