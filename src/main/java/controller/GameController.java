package controller;

import model.Car;
import model.Cars;
import view.GameView;

import java.util.List;

public class GameController {
    private GameView gameView = new GameView();

    public void play() {
        gameView.showStartMessage();

        gameView.showPleaseInputMessage();
        Cars cars = gameView.inputCars();
        gameView.showHowManyTimeTryMessage();
        int moveTimes = gameView.inputMoveTimes();

        for (int i = 0; i < moveTimes; i++) {
            cars.race();
            gameView.showCars(cars);
        }

        List<Car> winners = cars.getWinners();
        String winnersName = gameView.getWinnersName(winners);
        gameView.showFinallyWinMessage(winnersName);
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
