package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FinalRoundChecker;

public class Service {

    private final Cars cars;
    private FinalRoundChecker finalRoundChecker;

    private final String CAR_NAME_DELIMITER = ",";

    public Service() {
        this.cars = new Cars();
    }

    public void makeCars(String carNames) {
        for (String name : carNames.split(CAR_NAME_DELIMITER)) {
            cars.add(new Car(name));
        }
    }

    public void setNumberOfRounds(int numberOfRounds) {
        finalRoundChecker = new FinalRoundChecker(numberOfRounds);
    }
}
