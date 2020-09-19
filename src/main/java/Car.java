import java.util.Scanner;

public class Car {
    private final String name;
    private int position = 0;

    private Scanner scanner = new Scanner(System.in);

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
