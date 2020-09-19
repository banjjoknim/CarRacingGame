import java.util.List;
import java.util.Map;

public class Game {
    private Operation operation = new Operation();
    private Print print = new Print();

    void play() {
        print.printStartGame();
        print.printPleaseInput();
        List<Car> cars = operation.getCars();
        Map<Car, Integer> carInfos = operation.init(cars);

        print.printHowManyTimesTry();
        int currentMoveTimes = 0;
        int moveTimes = operation.inputMoveTimes();

        proceed(cars, carInfos, moveTimes, currentMoveTimes);

        int maxPosition = operation.getMaxPosition(cars, carInfos);
        String winners = operation.getWinnderNames(cars, carInfos, maxPosition);
        print.printWinners(winners);
    }

    private void proceed(List<Car> cars, Map<Car, Integer> carInfos, int moveTimes, int currentMoveTimes) {
        while (currentMoveTimes < moveTimes) {
            currentMoveTimes++;
            for (int i = 0; i < cars.size(); i++) {
                operation.action(cars.get(i), carInfos);
                print.printCarInfos(cars.get(i), carInfos);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
