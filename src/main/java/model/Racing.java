package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> cars;

    public Racing(String inputNames) {
        this.cars = Arrays.stream(inputNames.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        cars.stream()
            .forEach(Car::drive);
    }

    public String getWinners() {
        return cars.stream()
            .filter(car -> isWinner(car))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private boolean isWinner(Car car) {
        return getMaxPosition() == car.getPosition();
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

}
