import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintTest {
    private static final String START_GAME_MESSAGE = "자동차 경주 게임을 시작합니다.";
    private static final String PLEASE_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TIMES_TRY_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String IS_WIN = " 이(가) 최종 우승하였습니다.";
    private static final String PLEASE_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";

    private Print print = new Print();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @ParameterizedTest
    @CsvSource(value = {"name,0,name : ","name,5,name : -----","hi,3,hi : ---","hello,2,hello : --"})
    void printCarInfos(String name, String position, String expectedMessage) {
        Car car = new Car(name);
        Map<Car, Integer> carInfos = new HashMap<>();
        carInfos.put(car, Integer.valueOf(position));
        print.printCarInfos(car, carInfos);
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(expectedMessage);
    }

    @Test
    void printStartGame() {
        print.printStartGame();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(START_GAME_MESSAGE);
    }

    @Test
    void printPleaseInput() {
        print.printPleaseInput();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(PLEASE_INPUT);
    }

    @Test
    void printPleaseInputAgain() {
        print.printPleaseInputAgain();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(PLEASE_INPUT_AGAIN);
    }

    @Test
    void printHowManyTimesTry() {
        print.printHowManyTimesTry();
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(HOW_MANY_TIMES_TRY_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"ok:ok", "ok, hi:ok, hi", "hong, her:hong, her"}, delimiter = ':')
    void printWinners(String winners, String message) {
        print.printWinners(winners);
        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(message + IS_WIN);
    }
}
