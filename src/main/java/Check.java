import java.util.Arrays;
import java.util.Map;

public class Check {
    private static final boolean WINNER = true;
    private static final boolean LOSER = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private static final boolean CORRECT_NAMES = true;
    private static final boolean NOT_CORRECT_NAMES = false;

    private boolean isNotBlankNames(String names) {
        return Arrays.stream(names.split(","))
            .map(name -> name.trim())
            .allMatch(name -> !"".equals(name));
    }

    private boolean isLengthIsBelowFiveNames(String names) {
        return Arrays.stream(names.split(","))
            .map(name -> name.trim())
            .mapToInt(name -> name.length())
            .allMatch(length -> length <= CORRECT_NAME_LENGTH_LIMIT);
    }

    boolean isCorrectNames(String names) {
        if (isNotBlankNames(names) && isLengthIsBelowFiveNames(names)) {
            return CORRECT_NAMES;
        }
        return NOT_CORRECT_NAMES;
    }

    boolean isWinner(Car car, Map<Car, Integer> cars, int maxPosition) {
        int position = cars.get(car);
        if (maxPosition == position) {
            return WINNER;
        }
        return LOSER;
    }
}
