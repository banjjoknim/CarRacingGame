import java.util.List;
import java.util.Map;

public class Game {
    private Condition condition = new Condition();
    private Check check = new Check();
    private Operation operation = new Operation();
    private Print print = new Print();

    void play() {
        print.printStartGame();
        print.printPleaseInput();
        String names = operation.inputNames();
        List<Car> cars = operation.setCars(names);
        Map<Car, Integer> carInfos = operation.init(cars);

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
        print.printWinners(cars, carInfos, maxPosition);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
