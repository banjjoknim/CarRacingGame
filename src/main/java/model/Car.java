package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private static final boolean WINNER = true;
    private static final boolean LOSER = false;
    private static final int DRIVE_POSITION = 1;
    private static final int CONDITION_MIN_VALUE = 0;
    private static final int CONDITION_MAX_VALUE = 10;
    private static final int CONDITION_GOOD_MIN_VALUE = 4;
    private static final boolean GOOD = true;
    private static final boolean BAD = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isNotBlank(String name) {
        return !name.trim().isEmpty();
    }

    private boolean isLengthIsBelowCorrectNameLengthLimit(String name) {
        return name.trim().length() <= CORRECT_NAME_LENGTH_LIMIT;
    }

    public boolean isCorrectName() {
        return isNotBlank(name) && isLengthIsBelowCorrectNameLengthLimit(name);
    }

    public List<Car> setUpCars(List<Car> cars) {
        Car car = new Car(name.trim());
        cars.add(car);
        return cars;
    }

    public int createConditionValue() {
        int conditionValue = (int) (CONDITION_MIN_VALUE + Math.random() * CONDITION_MAX_VALUE);
        return conditionValue;
    }

    private boolean isGood(int conditionValue) {
        if (conditionValue >= CONDITION_GOOD_MIN_VALUE) {
            return GOOD;
        }
        return BAD;
    }

    public static List<Car> setCars(String input) {
        List<Car> cars = new ArrayList<>();
        String[] names = input.split(",");
        boolean isCorrectNames = Arrays.stream(names)
            .map(Car::new)
            .allMatch(car -> car.isCorrectName());
        if (isCorrectNames) {
            Arrays.stream(names)
                .map(Car::new)
                .forEach(car -> car.setUpCars(cars));
        }
        return cars;
    }

    public void drive(int conditionValue) {
        if (isGood(conditionValue)) {
            this.position = this.position + DRIVE_POSITION;
        }
    }


    public static void proceed(List<Car> cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            int conditionValue = car.createConditionValue();
            car.drive(conditionValue);
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(car -> car.position)
            .max()
            .getAsInt();
    }

    private static boolean isWinner(Car car, int maxPosition) {
        if (maxPosition == car.position) {
            return WINNER;
        }
        return LOSER;
    }

    public static String getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> isWinner(car, maxPosition))
            .map(car -> car.name)
            .collect(Collectors.joining(", "));
    }

}
