import java.util.List;
import java.util.Map;

public class Game {
    private Operation operation = new Operation();
    private Actions actions = new Actions();
    private Condition condition = new Condition();
    private Print print = new Print();

    void play() {
        print.printStartGame();
        print.printPleaseInput();

        String names = operation.setCarNames();
        List<Car> cars = operation.setCars(names);
        Map<Car, Integer> carStates = operation.init(cars);

        print.printHowManyTimesTry();
        int currentMoveTimes = 0;
        int moveTimes = operation.inputMoveTimes();

        proceed(cars, carStates, moveTimes, currentMoveTimes);

        int maxPosition = operation.getMaxPosition(cars, carStates);
        String winners = operation.getWinnerNames(cars, carStates, maxPosition);
        print.printWinners(winners);
    }

    private void proceed(List<Car> cars, Map<Car, Integer> carInfos, int moveTimes, int currentMoveTimes) {
        while (currentMoveTimes < moveTimes) {
            currentMoveTimes++;
            for (int i = 0; i < cars.size(); i++) {
                int conditionValue = condition.createConditionValue();
                boolean currentCondition = condition.isGood(conditionValue);
                actions.action(cars.get(i), carInfos, currentCondition);
                print.printCarState(cars.get(i), carInfos);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
