package racingcar;

import java.util.Random;

class RacingGame {
    private final Cars cars = new Cars();
    private int totalRound;

    private final static int FORWARD_CRITERION = 4;
    private final static int BOUNDARY_ZERO_TO_NINE = 10;
    private final static Random RANDOM = new Random();

    RacingGame(String[] carNames, int totalRound) {
        addCars(carNames);
        this.totalRound = totalRound;
    }

    private void addCars(String[] carNames) {
        for(String carName : carNames){
            cars.addCar(new Car(carName));
        }
    }

    Cars playOneRound() {
        for (Car car : cars) {
            car.randomForward(isMove());
        }
        return cars;
    }

    int getTotalRound() {
        return totalRound;
    }

    private boolean isMove() {
        return (RANDOM.nextInt(BOUNDARY_ZERO_TO_NINE) >= FORWARD_CRITERION);
    }
}
