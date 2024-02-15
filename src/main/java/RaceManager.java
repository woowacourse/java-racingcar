import domain.Car;
import domain.CarFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.InputView;

public class RaceManager {
    private static List<Car> cars;
    private static int numberOfAttempts;

    public RaceManager() {
        repeatUntilGetValidCarNames();
        repeatUntilGetValidNumberOfAttempts();
    }

    private static void repeatUntilGetValidCarNames() {
        try {
            String carNames = InputView.readCarNames();
            CarFactory carFactory = new CarFactory();
            cars = carFactory.generateCars(carNames);
        } catch (IOException | IllegalArgumentException e) {
            repeatUntilGetValidCarNames();
        }
    }

    private static void repeatUntilGetValidNumberOfAttempts() {
        try {
            numberOfAttempts = InputView.readNumberOfAttempts();
        } catch (IOException | IllegalArgumentException e) {
            repeatUntilGetValidNumberOfAttempts();
        }
    }

    public static void run() {
        String raceResult = race();
    }

    public static String race() {
        StringBuilder log = new StringBuilder();

        //indent 2
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
            log.append(car.toString());
        }

        log.append(getResult());

        return log.toString();
    }


    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static String getResult() {
        StringBuilder result = new StringBuilder("실행 결과");

        for (int i = 0; i < numberOfAttempts; i++) {
            result.append(race()).append("\n\n");
        }

        // TODO: 최종 우승자
        List<Car> winners = getWinners(getMaxPosition());
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        String winnerResult = String.join(", ", winnerNames).concat("가 최종 우승했습니다.");

        return result.append(winnerResult).toString();
    }

    private static int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static List<Car> getWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}