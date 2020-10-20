package view;

import java.util.Arrays;
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
    private static final String CAR_POSITION_VIEW = "-";
    private static final String IS_NOT_POSITIVE_NUMBER = "시도 횟수는 1이상의 정수여야 합니다.";

    private static Scanner scanner = new Scanner(System.in);

    public static void showStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void showPleaseInputMessage() {
        System.out.println(PLEASE_INPUT_MESSAGE);
    }

    public static void showHowManyTimeTryMessage() {
        System.out.println(HOW_MANY_TIMES_TRY_MESSAGE);
    }

    private static void showPleaseInputAgainMessage() {
        System.out.println(PLEASE_INPUT_AGAIN_MESSAGE);
    }

    public static void showFinallyWinMessage(List<Car> winners) {
        System.out.println(getWinnersName(winners) + IS_FINALLY_WIN_MESSAGE);
    }

    public static String getWinnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public static Cars inputCars() {
        try {
            showPleaseInputMessage();
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

    public static int inputMoveTimes() { //todo : moveTime 객체로 만들기.
        try {
            showHowManyTimeTryMessage();
            if (!scanner.hasNextInt()) {
                scanner.next();
                showPleaseInputAgainMessage();
                return inputMoveTimes();
            }

            int moveTimes = scanner.nextInt();
            if (!isPositiveNumber(moveTimes)) {
                throw new IllegalArgumentException(IS_NOT_POSITIVE_NUMBER);
            }
            return moveTimes;
        } catch (IllegalArgumentException e) {
            showPleaseInputAgainMessage();
            return inputMoveTimes();
        }
    }

    private static boolean isPositiveNumber(int moveTimes) {
        return moveTimes > 0;
    }

    public static void showCars(Cars cars) {
        cars.getCars().stream()
                .forEach(car -> showCarStatus(car));
        System.out.println();
    }

    private static void showCarStatus(Car car) {
        System.out.println(car.getName() + " : " + getPositionView(car.getPosition()));
    }

    private static String getPositionView(int position) {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += CAR_POSITION_VIEW;
        }
        return positionView;
    }
}
