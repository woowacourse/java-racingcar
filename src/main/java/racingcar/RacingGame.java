package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGame {

    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final int gameCount;

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();


    public RacingGame() {
        initRacing();
        this.gameCount = inputView.inputGameTime();
    }

    private void initRacing() {
        String input = inputView.inputCarName();
        String[] split = input.split(",");
        Arrays.stream(split).forEach(carName -> cars.add(new Car(carName.trim())));
    }

    private int generateRandomNumber() {
        return (int) ((Math.random() * (RANGE_MAX - RANGE_MIN)) + RANGE_MIN);
    }

    private void updateCarPosition() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = generateRandomNumber();
            cars.get(i).move(randomNumber);
        }
    }

    public void playingGame() {
        for (int i = 0; i < gameCount; i++) {
            updateCarPosition();
            printPosition();
        }
    }

    private void printPosition() {
        cars.forEach(s -> outputView.printPosition(s.getName(), s.getPosition()));
        System.out.println();
    }

    public void viewResult() {
        Integer max = cars.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder()).orElse(null);
        cars.stream().filter(car -> car.getPosition() == max)
                .forEach(car -> winners.add(car.getName()));
        printPosition();
        outputView.printWinners(winners);
    }
}
