package domain;

import view.OutputView;

import java.util.Random;

public class GameManager {
    private final Random random;
    private final Cars cars;
    private final AttemptNumber attemptNumber;

    public GameManager(Cars cars, AttemptNumber attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.random = new Random();
    }

    public void playGame() {
        int repeatCount = attemptNumber.getNumber();
        for (int count = 0; count < repeatCount; count++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        int carsSize = cars.getSize();
        for (int count = 0; count < carsSize; count++) {
            Car car = cars.getCar(count);
            car.move(getRandomNumber());
            OutputView.printCurrentPosition(car.getName(), car.getPosition());
        }
        OutputView.println();
    }

    private int getRandomNumber() {
        return random.nextInt(10);
    }
}
