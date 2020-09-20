import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Check {
    private static final boolean WINNER = true;
    private static final boolean LOSER = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private static final boolean CORRECT_NAMES = true;
    private static final boolean NOT_CORRECT_NAMES = false;

    boolean isCorrectNames(String names) {
        boolean lengthIsBelowFive = Arrays.stream(names.split(","))
            .mapToInt(name -> name.length())
            .allMatch(length -> length <= CORRECT_NAME_LENGTH_LIMIT);
        if (lengthIsBelowFive) {
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
