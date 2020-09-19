import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {

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

}
