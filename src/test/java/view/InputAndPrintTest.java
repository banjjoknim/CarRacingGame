package view;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sun.beans.editors.ByteEditor;

import model.Car;

class InputAndPrintTest {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String IS_WIN = " 이(가) 최종 우승하였습니다.";
    private static final String PLEASE_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";

    InputAndPrint inputAndPrint = new InputAndPrint();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void inputCarNamesTest(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Scanner scanner = new Scanner(System.in);
        assertThat(scanner.nextLine()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
    void inputMoveTimesTest(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Scanner scanner = new Scanner(System.in);
        assertThat(scanner.nextLine()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"sdas"})
    void printCarStatesTest(String input) {
        List<Car> cars = new ArrayList<>();
        Car car = new Car(input);
        cars.add(car);
        inputAndPrint.printCarStates(cars);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("sdas : ");
    }

    @Test
    void printStartGameTest() {
        inputAndPrint.printStartGame();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(START_GAME_MESSAGE);
    }

    @Test
    void printPleaseInputTest() {
        inputAndPrint.printPleaseInput();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(PLEASE_INPUT);
    }

    @Test
    void printPleaseInputAgainTest() {
        inputAndPrint.printPleaseInputAgain();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(PLEASE_INPUT_AGAIN);
    }

    @Test
    void printHowManyTimesTryTest() {
        inputAndPrint.printHowManyTimesTry();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(HOW_MANY_TIMES_TRY_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, crong"})
    void printWinnersTest(String winners) {
        inputAndPrint.printWinners(winners);
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(winners + IS_WIN);
    }
}
