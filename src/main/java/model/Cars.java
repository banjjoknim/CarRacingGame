package model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return new Cars(cars).cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int conditionValue = car.getConditionValue();
            car.drive(conditionValue);
        }
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> isWinner(car, maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private boolean isWinner(Car car, int maxPosition) {
        return maxPosition == car.getPosition();
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

}
