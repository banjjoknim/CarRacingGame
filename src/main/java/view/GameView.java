package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Car;
import model.Cars;

public class GameView {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String IS_FINALLY_WIN_MESSAGE = " 이(가) 최종 우승하였습니다.";
    private static final String PLEASE_INPUT_AGAIN_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";

    private Scanner scanner = new Scanner(System.in);

    public void showStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void showPleaseInputMessage() {
        System.out.println(PLEASE_INPUT_MESSAGE);
    }

    public void showHowManyTimeTryMessage() {
        System.out.println(HOW_MANY_TIMES_TRY_MESSAGE);
    }

    public void showPleaseInputAgainMessage() {
        System.out.println(PLEASE_INPUT_AGAIN_MESSAGE);
    }

    public void showFinallyWinMessage(String winners) {
        System.out.println(winners + IS_FINALLY_WIN_MESSAGE);
    }

    public Cars inputCars() {
        try {
            String inputNames = scanner.nextLine();
            List<Car> cars = Arrays.stream(inputNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            showPleaseInputAgainMessage();
            return inputCars();
        }
    }

    public int inputMoveTimes() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            showPleaseInputAgainMessage();
            scanner = new Scanner(System.in); // Scanner의 버그로 인해 다시 초기화해야 한다.
            return inputMoveTimes();
        }
    }

    public void showCars(Cars cars) {
        cars.getCars().stream()
            .forEach(this::showCarStatus);
        System.out.println();
    }

    private void showCarStatus(Car car) {
        System.out.print(car.getName() + " : " + car.getPositionView(car.getPosition())+"\n");
    }
}
