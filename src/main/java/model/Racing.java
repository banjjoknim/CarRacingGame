package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    public List<Car> setCars(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void race(List<Car> cars) {
        cars.stream()
            .forEach(Car::drive);
    }

    public String getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> isWinner(car, maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

    private boolean isWinner(Car car, int maxPosition) {
        return maxPosition == car.getPosition();
    }
}
