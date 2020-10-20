package controller;

import java.util.List;

import model.Car;
import model.Cars;
import view.GameView;

public class GameController {

    public void play() {
        GameView.showStartMessage();

        Cars cars = GameView.inputCars();
        int moveTimes = GameView.inputMoveTimes();

        for (int i = 0; i < moveTimes; i++) {
            cars.race();
            GameView.showCars(cars);
        }

        List<Car> winners = cars.getWinners();
        GameView.showFinallyWinMessage(winners);
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
