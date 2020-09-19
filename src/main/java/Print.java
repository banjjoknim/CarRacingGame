import java.util.Map;

public class Print {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";

    private void printCarName(Car car) {
        System.out.println(car.getName());
    }

    private void printCarPosition(int position) {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += "-";
        }
        System.out.println(positionView);
    }

    void printCarInfos(Car car, Map<Car, Integer> carInfos) {
        printCarName(car);
        System.out.print(" : ");
        printCarPosition(carInfos.get(car));
    }

    void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    void printPleaseInput() {
        System.out.println(PLEASE_INPUT);
    }

    void printHowManyTimesTry() {
        System.out.println(HOW_MANY_TIMES_TRY_MESSAGE);
    }
}
