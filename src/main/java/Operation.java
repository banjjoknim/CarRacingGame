import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Operation {
    private Scanner scanner = new Scanner(System.in);
    private Check check = new Check();
    private Print print = new Print();

    String inputNames() {
        return scanner.next();
    }

    private List<Car> setCars(String names) {
        return Arrays.stream(names.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    List<Car> getCars() {
        while (true) {
            String names = inputNames();
            List<Car> cars = setCars(names);
            if (!check.isCorrectNames(cars)) {
                print.printPleaseInputAgain();
                continue;
            }
            return cars;
        }
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
            .filter(car -> check.isWinner(car, carInfos, maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

}
