package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

    private static final int MIN_NUMBER_OF_POWER = 0;
    private static final int MAX_NUMBER_OF_POWER = 9;

    private final Cars cars;
    private final Round round;

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Cars> simulateCarsInRound() {
        List<Cars> roundResults = new ArrayList<>();
        while (round.isRemain()) {
            cars.raceWithNumbersOfPower(prepareNumbersOfPower());
            Cars carPerformance = new Cars(cars.values());
            roundResults.add(carPerformance);
            round.decreaseCount();
        }
        return roundResults;
    }

    private List<Integer> prepareNumbersOfPower() {
        List<Integer> numbersOfPowers = new ArrayList<>();
        int registeredCarsSize = cars.valuesSize();
        for (int i = 0; i < registeredCarsSize; i++) {
            numbersOfPowers.add(decideNumberOfPower());
        }
        return numbersOfPowers;
    }

    private int decideNumberOfPower() {
        return RandomNumberGenerator.generate(MIN_NUMBER_OF_POWER, MAX_NUMBER_OF_POWER);
    }

    public List<String> pickOutWinners() {
        int maxDistance = cars.findMaxDistance();
        return cars.findCarNamesWithSameDistance(maxDistance);
    }
}
