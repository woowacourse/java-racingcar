package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGame {
    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private final int gameCount;

    public RacingGame() {
        initRacing();
        this.gameCount = inputView.inputGameTime();
    }

    private void initRacing() {
        String[] input = inputView.inputCarName();
        Arrays.stream(input).forEach(s -> cars.add(new Car(s)));
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
        int maxPosition = getCarMaxPosition();
        cars.stream().filter(car -> car.getPosition() == maxPosition).forEach(car -> winners.add(car.getName()));
        printPosition();
        outputView.printWinners(winners);
    }

    private int getCarMaxPosition() {
        int temp = -1;
        for (int i = 0; i < cars.size(); i++) {
            if (temp < cars.get(i).getPosition()) {
                temp = cars.get(i).getPosition();
            }
        }
        int max = temp;
        return max;
    }

}
