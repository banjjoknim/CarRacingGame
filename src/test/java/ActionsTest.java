import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ActionsTest {
    private static final boolean GOOD = true;
    private static final boolean BAD = false;

    Actions actions = new Actions();

    @ParameterizedTest
    @CsvSource(value = {"name:3:4","hi!:4:5","hello:2:3"}, delimiter = ':')
    void driveBelongToActionTest(String name, String beforePosition, String afterPosition) {
        Map<Car, Integer> carInfos = new HashMap<>();
        Car car = new Car(name);
        carInfos.put(car, Integer.valueOf(beforePosition));

        actions.action(car, carInfos, GOOD);
        assertThat(carInfos.get(car))
            .isEqualTo(Integer.valueOf(afterPosition));
    }

    @ParameterizedTest
    @CsvSource(value = {"name:3:3","hi!:4:4"}, delimiter = ':')
    void stopBelongToActionTest(String name, String beforePosition, String afterPosition) {
        Map<Car, Integer> carInfos = new HashMap<>();
        Car car = new Car(name);
        carInfos.put(car, Integer.valueOf(beforePosition));

        actions.action(car, carInfos, BAD);
        assertThat(carInfos.get(car))
            .isEqualTo(Integer.valueOf(afterPosition));
    }

}
