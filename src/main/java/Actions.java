import java.util.Map;

public class Actions {
    private Condition condition = new Condition();

    private void drive(Car car, Map<Car, Integer> carInfos) {
        int currentPosition = carInfos.get(car);
        carInfos.put(car, currentPosition + 1);
    }

    private void stop(Car car, Map<Car, Integer> carInfos) {
        int currentPosition = carInfos.get(car);
        carInfos.put(car, currentPosition);
    }

    void action(Car car, Map<Car, Integer> carInfos, boolean condition) {
        if (condition) {
            drive(car, carInfos);
            return;
        }
        stop(car, carInfos);
    }
}
