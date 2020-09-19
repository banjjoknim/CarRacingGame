import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Operation {
    private Scanner scanner = new Scanner(System.in);
    private Condition condition = new Condition();

    Map<Car, Integer> init(List<Car> cars) {
        Map<Car, Integer> carInfos = new HashMap<>();

        int numberOfCars = cars.size();
        for (int i = 0; i < numberOfCars; i++) {
            Car car = cars.get(i);
            carInfos.put(car, car.getPosition());
        }

        return carInfos;
    }

    void drive(Car car, Map<Car, Integer> carInfos) {
        int currentPosition = carInfos.get(car);
        carInfos.put(car, currentPosition + 1);
    }

    void stop(Car car, Map<Car, Integer> carInfos) {
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

}
