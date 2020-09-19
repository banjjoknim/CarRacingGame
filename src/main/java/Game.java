import java.util.List;
import java.util.Map;

public class Game {
    private Operation operation = new Operation();
    private Print print = new Print();
    private Check check = new Check();

    void play() {
        print.printStartGame();
        print.printPleaseInput();
        List<Car> cars;
        Map<Car, Integer> carInfos = null;

        while (true) {
            String names = operation.inputNames();
            cars = operation.setCars(names);
            if (!check.isCorrectNames(cars)) {
                print.printPleaseInputAgain();
                continue;
            }
            carInfos = operation.init(cars);
            break;
        }

        print.printHowManyTimesTry();
        int moveTimes = operation.inputMoveTimes();
        int currentMoveTimes = 0;

        while (currentMoveTimes < moveTimes) {
            currentMoveTimes++;
            for (int i = 0; i < cars.size(); i++) {
                operation.action(cars.get(i), carInfos);
                print.printCarInfos(cars.get(i), carInfos);
            }
            System.out.println();
        }

        int maxPosition = operation.getMaxPosition(cars, carInfos);
        String winners = operation.getWinnderNames(cars, carInfos, maxPosition);
        print.printWinners(winners);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
