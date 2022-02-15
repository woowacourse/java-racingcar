package racingCar.controller.service;

import java.util.Arrays;
import java.util.List;
import racingCar.model.Car;
import racingCar.model.RacingCars;
import racingCar.model.RoundCount;
import racingCar.model.utils.Util;
import racingCar.view.Output;

public class RacingCarsService {
    private RacingCars cars;
    private RoundCount roundCount;

    public void initiateCars(String nameString) {
        String[] names = Util.separate(nameString);
        cars = new RacingCars(Arrays.asList(names));
    }

    public void initiateCount(int countInput) {
        roundCount = new RoundCount(countInput);
    }

    public void playGame() {
        goRound();
        if (roundCount.isFinish()) {
            return;
        }
        playGame();
    }

    public void goRound() {
        cars.go();
        roundCount.minusOne();
        Output.printRoundResult(cars.get());
    }

    public List<Car> getWinnerCars() {
        return cars.getSamePositionCars(cars.getMaxPosition());
    }
}