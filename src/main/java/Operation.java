import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Operation {
    private Scanner scanner = new Scanner(System.in);
    private Condition condition = new Condition();

    private void drive(Car car, Map<Car, Integer> carInfos) {
        int currentPosition = carInfos.get(car);
        carInfos.put(car, currentPosition + 1);
    }

    private void stop(Car car, Map<Car, Integer> carInfos) {
        int currentPosition = carInfos.get(car);
        carInfos.put(car, currentPosition);
    }

    void action(Car car, Map<Car, Integer> carInfos) {
        if (condition.isGood()) {
            drive(car, carInfos);
            return;
        }
        stop(car, carInfos);
    }

    int inputMoveTimes() {
        return scanner.nextInt();
    }

    int getMaxPosition(List<Car> cars, Map<Car, Integer> carInfos) {
        return cars.stream()
            .mapToInt(car -> carInfos.get(car))
            .max()
            .getAsInt();
    }

    String getWinnderNames(List<Car> cars, Map<Car, Integer> carInfos, int maxPosition) {
        return cars.stream()
            .filter(car -> carInfos.get(car) == maxPosition)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

}
