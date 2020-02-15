package racingcargame.domain.game;

import racingcargame.domain.car.Car;
import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.result.CarSnapShot;
import racingcargame.domain.result.RoundResult;
import racingcargame.domain.trialtimes.TrialTimes;
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
            throw new IllegalArgumentException("자동차 경주는 최소 2대 이상의 자동차가 있을 경우 가능합니다.");
        }

        Set<Car> carSet = new HashSet<>(cars);
        if (carSet.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
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
