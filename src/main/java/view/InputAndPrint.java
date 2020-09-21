package view;

import java.util.List;
import java.util.Scanner;

import model.Car;

public class InputAndPrint {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String IS_WIN = " 이(가) 최종 우승하였습니다.";
    private static final String PLEASE_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";

    Scanner scanner = new Scanner(System.in);

    public String inputCarNames(){
        return scanner.nextLine();
    }

    public int inputMoveTimes() {
        return scanner.nextInt();
    }

    private void printCarName(Car car) {
        System.out.print(car.getName());
    }

    private void printCarPosition(int position) {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += "-";
        }
        System.out.println(positionView);
    }

    public void printCarStates(List<Car> cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            printCarName(cars.get(i));
            System.out.print(" : ");
            printCarPosition(cars.get(i).getPosition());
        }
        System.out.println();
    }

    public void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printPleaseInput() {
        System.out.println(PLEASE_INPUT);
    }

    public void printPleaseInputAgain() {
        System.out.println(PLEASE_INPUT_AGAIN);
    }

    public void printHowManyTimesTry() {
        System.out.println(HOW_MANY_TIMES_TRY_MESSAGE);
    }

    public void printWinners(String winners) {
        System.out.println(winners + IS_WIN);
    }
}
