import java.util.Map;

public class Check {
    private static final boolean WINNER = true;
    private static final boolean LOSER = false;
    private static final int CORRECT_NAME_LENGTH_LIMIT = 5;
    private static final boolean CORRECT_NAME = true;
    private static final boolean NOT_CORRECT_NAME = false;
    private static final String UNSUITABLE_NAME = "부적절한 이름입니다. 다시 입력해주세요.";

    boolean isCorrectName(Car car) {
        int nameLength = car.getName().length();
        if (nameLength <= CORRECT_NAME_LENGTH_LIMIT) {
            return CORRECT_NAME;
        }
        return NOT_CORRECT_NAME;
    }

    boolean isWinner(Car car, Map<Car, Integer> cars, int maxPosition) {
        int position = cars.get(car);
        if (maxPosition==position){
            return WINNER;
        }
        return LOSER;
    }
}
