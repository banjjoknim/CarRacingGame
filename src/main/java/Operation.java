import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Operation {
    private Scanner scanner = new Scanner(System.in);

    List<Car> setCars() {
        String names= scanner.next();

        return Arrays.stream(names.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
