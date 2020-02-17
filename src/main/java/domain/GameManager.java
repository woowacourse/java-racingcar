package domain;


import view.OutputView;

public class GameManager {
    private final Cars cars;
    private final AttemptNumber attemptNumber;

    public GameManager(Cars cars, AttemptNumber attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
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

    }
}
