package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.OutputView;

public class RacingCarGame {
    public static final int MOVE_NUMBER = 4;
    private final Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void playGame(int attemptLimit) {
        OutputView.printHeadLine();
        for (int i = 0; i < attemptLimit; i++) {
            playRacing();
            OutputView.printResult(cars);
        }
    }

    private void playRacing() {
        for (Car car : cars.getCars()) {
            goOrStop(car, randomNumberGenerator());
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            car.incLocation();
        }
    }

    public List<String> getWinnerName() {
        int max = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            int location = car.getLocation();
            if (location == max) {
                winners.add(car.getCarName());
            }
            if (location > max) {
                winners.clear();
                max = location;
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
