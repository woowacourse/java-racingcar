package racingcargame.game;

import racingcargame.domain.Car;
import racingcargame.domain.CarRaceResult;
import racingcargame.domain.CarSnapShot;
import racingcargame.domain.RoundResult;
import racingcargame.domain.TrialTimes;
import racingcargame.genrator.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarRace {

    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private final List<Car> cars;

    public CarRace(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        Set<Car> carSet = new HashSet<>(cars);
        if (carSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public CarRaceResult run(TrialTimes trialTimes) {
        List<RoundResult> roundResultList = new ArrayList<>();

        for (int i = 0; i < trialTimes.getTrialTimes(); i++) {
            RoundResult roundResult = runOneTurn();
            roundResultList.add(roundResult);
        }

        return new CarRaceResult(roundResultList);
    }

    private RoundResult runOneTurn() {
        for (Car car : cars) {
            int randomNumber = RandomGenerator.generateRandom();
            car.move(randomNumber);
        }

        List<CarSnapShot> carSnapShotList = cars.stream().map(CarSnapShot::new).collect(Collectors.toList());
        return new RoundResult(carSnapShotList);
    }
}
