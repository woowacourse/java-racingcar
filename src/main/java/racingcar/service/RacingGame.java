package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.RoundResult;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

    private static final int MIN_NUMBER_OF_POWER = 0;
    private static final int MAX_NUMBER_OF_POWER = 9;

    public Cars registerCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public RoundResult processRound(Cars cars) {
        int registeredCarsSize = cars.cars().size();
        List<Integer> numbersOfPower = prepareNumbersOfPower(registeredCarsSize);
        cars.raceWithNumbersOfPower(numbersOfPower);
        return new RoundResult(cars);
    }

    public List<String> pickOutWinners(Cars cars) {
        int maxDistance = cars.findMaxDistance();
        return cars.findCarNamesWithSameDistance(maxDistance);
    }

    private List<Integer> prepareNumbersOfPower(int registeredCarsSize) {
        List<Integer> numbersOfPowers = new ArrayList<>();
        for (int i = 0; i < registeredCarsSize; i++) {
            numbersOfPowers.add(decideNumberOfPower());
        }
        return numbersOfPowers;
    }

    private int decideNumberOfPower() {
        return RandomNumberGenerator.generate(MIN_NUMBER_OF_POWER, MAX_NUMBER_OF_POWER);
    }
}
