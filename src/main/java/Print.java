import java.util.Map;

public class Print {
    
    private void printCarName(Car car) {
        System.out.println(car.getName());
    }

    private void printCarPosition(int position) {
        String positionView = "";
        for (int i = 0; i < position; i++) {
            positionView += "-";
        }
        System.out.println(positionView);
    }

    void printCarInfos(Car car, Map<Car, Integer> carInfos){
        printCarName(car);
        System.out.print(" : ");
        printCarPosition(carInfos.get(car));
    }
}
