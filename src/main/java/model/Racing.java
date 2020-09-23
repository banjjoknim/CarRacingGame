package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private static final boolean WINNER = true;
    private static final boolean LOSER = false;

    public List<Car> setCars(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void race(List<Car> cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            car.drive(car.getConditionValue());
        }
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

    public String getWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
            .filter(car -> isWinner(car, maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private boolean isWinner(Car car, int maxPosition) {
        if (maxPosition == car.getPosition()) {
            return WINNER;
        }
        return LOSER;
    }
}
