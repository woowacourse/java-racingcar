package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Round round;
    private final NumberOfPower numberOfPower;

    public RacingGame(Cars cars, Round round, NumberOfPower numberOfPower) {
        this.cars = cars;
        this.round = round;
        this.numberOfPower = numberOfPower;
    }

    public List<Cars> simulateCarsInRound() {
        List<Cars> roundResults = new ArrayList<>();
        while (round.isRemain()) {
            int registeredCarsSize = cars.valuesSize();
            List<Integer> numbersOfPower = numberOfPower.generateNumbersOfPower(registeredCarsSize);
            Cars roundResult = cars.raceWithNumbersOfPower(numbersOfPower);
            roundResults.add(roundResult);
            round.decreaseCount();
        }
        return roundResults;
    }

    public List<String> pickOutWinners() {
        int maxDistance = cars.findMaxDistance();
        return cars.findCarNamesWithSameDistance(maxDistance);
    }
}
