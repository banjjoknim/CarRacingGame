package controller;

import java.util.List;

import model.Car;
import view.InputAndPrint;

public class Game {
    InputAndPrint inputAndPrint = new InputAndPrint();

    public void play() {
        inputAndPrint.printStartGame();

        inputAndPrint.printPleaseInput();
        List<Car> cars = getCars();

        inputAndPrint.printHowManyTimesTry();
        int moveTimes = inputAndPrint.inputMoveTimes();
        race(cars, moveTimes);

        String winners = Car.getWinners(cars);
        inputAndPrint.printWinners(winners);
    }

    public void race(List<Car> cars, int moveTimes) {
        int currentMoveTimes = 0;
        while (currentMoveTimes < moveTimes) {
            currentMoveTimes++;
            Car.proceed(cars);
            inputAndPrint.printCarStates(cars);
        }
    }

    private List<Car> getCars() {
        List<Car> cars;
        while (true) {
            cars = Car.setCars(inputAndPrint.inputCarNames());
            if (cars.size() == 0) {
                inputAndPrint.printPleaseInputAgain();
                continue;
            }
            break;
        }
        return cars;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
