import domain.Car;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class Application {
    private static List<Car> cars;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // input
        while (makeCars())
            ;
        // car race
        // output

    }

    private static boolean makeCars() {
        try {
            String carNames = InputView.readCarNames();
            cars = generateCars(carNames);
            return true;
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }

    }

    private static List<Car> generateCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}