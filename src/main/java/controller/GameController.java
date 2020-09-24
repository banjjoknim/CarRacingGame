package controller;

import java.util.List;
import java.util.Scanner;

import model.Car;
import model.Racing;

public class GameController {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String IS_WIN = " 이(가) 최종 우승하였습니다.";
    public static final String PLEASE_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";
    private Scanner scanner = new Scanner(System.in);
    private Racing racing = new Racing();

    public void play() {
        System.out.println(START_GAME_MESSAGE);

        System.out.println(PLEASE_INPUT);
        List<Car> cars = inputCars();
        System.out.println(HOW_MANY_TIMES_TRY_MESSAGE);
        int moveTimes = inputMoveTimes();

        showProcess(moveTimes, cars);

        int maxPosition = racing.getMaxPosition(cars);
        String winners = racing.getWinners(cars, maxPosition);
        System.out.println(winners + IS_WIN);
    }

    private List<Car> inputCars() {
        while (true) {
            try {
                String inputNames = scanner.nextLine();
                return racing.setCars(inputNames);
            } catch (Exception e) {
                System.out.println(PLEASE_INPUT_AGAIN);
            }
        }
    }

    private int inputMoveTimes() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println(PLEASE_INPUT_AGAIN);
                scanner = new Scanner(System.in); // Scanner의 버그로 인해 다시 초기화해야 한다.
            }
        }
    }

    private void showProcess(int moveTimes, List<Car> cars) {
        for (int i = 0; i < moveTimes; i++) {
            racing.race(cars);
            showCars(cars);
            System.out.println();
        }
    }

    private void showCars(List<Car> cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.print(car.getPositionView());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
