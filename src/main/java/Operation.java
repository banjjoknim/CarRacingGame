import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Operation {
    private Scanner scanner = new Scanner(System.in);

    List<Car> setCars() {
        String names = scanner.next();

        return Arrays.stream(names.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

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
