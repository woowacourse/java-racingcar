import domain.Car;
import domain.CarFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.InputView;
import view.OutputView;

public class RaceManager {
    private static List<Car> cars;
    private static int numberOfAttempts;

    public RaceManager() {
        repeatUntilGetValidCarNames();
        repeatUntilGetValidNumberOfAttempts();
    }

    private void repeatUntilGetValidCarNames() {
        try {
            String carNames = InputView.readCarNames();
            CarFactory carFactory = new CarFactory();
            cars = carFactory.generateCars(carNames);
        } catch (IOException | IllegalArgumentException e) {
            repeatUntilGetValidCarNames();
        }
    }

    private void repeatUntilGetValidNumberOfAttempts() {
        try {
            numberOfAttempts = InputView.readNumberOfAttempts();
        } catch (IOException | IllegalArgumentException e) {
            repeatUntilGetValidNumberOfAttempts();
        }
    }

    public void run() {
        OutputView.printResult(getResult());
    }

    private String race() {
        StringBuilder log = new StringBuilder();

        //indent 2
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
            log.append(car.toString());
            log.append("\n");
        }
        return log.toString();
    }


    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String getResult() {
        StringBuilder result = new StringBuilder("실행 결과\n");

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

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<Car> getWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}