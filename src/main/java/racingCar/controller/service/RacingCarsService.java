package racingCar.controller.service;

import java.util.Arrays;
import java.util.List;
import racingCar.model.Car;
import racingCar.model.RacingCars;
import racingCar.model.RoundCount;
import racingCar.model.utils.Util;
import racingCar.view.Output;

public class RacingCarsService {
    public final RacingCars cars;
    public final RoundCount roundCount;

    public RacingCarsService(String names, String count) {
        this.cars = initiateCars(names);
        this.roundCount = initiateCount(count);
    }

    private RacingCars initiateCars(String nameString) {
        String[] names = Util.separate(nameString);
        return new RacingCars(Arrays.asList(names));
    }

    private RoundCount initiateCount(String countInput) {
        int count = Util.convertToInteger(countInput);
        return new RoundCount(count);
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