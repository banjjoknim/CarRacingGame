package controller;

import model.Cars;
import view.GameView;

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

        String winners = cars.getWinners();
        gameView.showFinallyWinMessage(winners);
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
