import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private int position = 0;

    private Scanner scanner = new Scanner(System.in);

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    String getInputNames() {
        return scanner.next();
    }

    List<Car> setCars(String names) {
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
