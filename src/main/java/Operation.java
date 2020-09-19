import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

}
