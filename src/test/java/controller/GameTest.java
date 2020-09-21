package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import model.Car;

class GameTest {
    Game game = new Game();

    @DisplayName("자동차 게임 진행 출력")
    @ParameterizedTest
    @ValueSource(strings = {"car1, car2", "carr1, carr2"})
    void raceTest(String input) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Car::new)
            .forEach(car -> cars.add(car));
        int moveTimes = 3;
        game.race(cars, moveTimes);
    }
}
