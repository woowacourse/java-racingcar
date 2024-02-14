import domain.Car;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.InputView;

public class Application {
    private static List<Car> cars;
    private static int numberOfAttempts;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (makeCars())
            ;
        while (getNumberOfAttempts())
            ;
        //실행결과 출력

        StringBuilder log = new StringBuilder("실행 결과");

        for (int i = 0; i < numberOfAttempts; i++) {
            log.append(race()).append("\n\n");
        }
        
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

    private static boolean getNumberOfAttempts() {
        try {
            numberOfAttempts = InputView.readNumberOfAttempts();
            return true;
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }
    }

    private static String race() {
        StringBuilder log = new StringBuilder();

        //indent 2
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
            log.append(car.toString());
        }

        return log.toString();
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}