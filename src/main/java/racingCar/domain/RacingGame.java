package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.car.Car;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.Engine;
import racingCar.domain.car.Engine.RandomEngine;

public class RacingGame {


    private final Cars cars;
    private int numOfRacingRound;

    public RacingGame(String[] carNames, int numOfRacingRound) {
        this.cars = new Cars(prepareCars(carNames));
        this.numOfRacingRound = numOfRacingRound;
    }

    public static List<Car> prepareCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(RacingGame::makeCar)
            .collect(Collectors.toList());
    }

    private static Car makeCar(String carName) {
        Engine engine = new RandomEngine();
        return new Car(carName, engine);
    }

    public void race() {
        cars.racePerRound();
        numOfRacingRound--;
    }


    public boolean isEnd() {
        return numOfRacingRound == 0;
    }

    public List<Car> getCars() {
        return cars.toList();
    }
}