package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Condition condition = new Condition();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int conditionValue = new Condition().getConditionValue();
            car.drive(conditionValue);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}
