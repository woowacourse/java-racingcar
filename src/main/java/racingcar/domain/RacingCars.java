package racingcar.domain;

import racingcar.RandomGenerator;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {

    private static final int ANY_INDEX = 0;
    private static final String EXCEPTION_NUMBER_OF_CAR = "[ERROR] 경기를 위한 자동차는 최소 2대이상이여야 합니다.";
    private List<RacingCar> racingCarBucket;

    public RacingCars(List<String> carNameBucket) {
        racingCarBucket = new ArrayList<>();
        for (String name : carNameBucket) {
            racingCarBucket.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCarBucket;
    }


    public void moveCars() {
        for (RacingCar racingCar : racingCarBucket) {
            racingCar.goOrStay(RandomGenerator.generateRandomNumber());
        }
    }

    public List<String> getCurrentRaceState() {
        List<String> currentRaceState = new ArrayList<>();
        for (RacingCar racingCar: racingCarBucket) {
            currentRaceState.add(racingCar.currentState());
        }
        return currentRaceState;
    }

    private RacingCar compareCarWithPosition(RacingCar sourceCar, RacingCar targetCar) {
        return sourceCar.compareCar(targetCar);
    }

    public List<String> getWinnerNameBucket() {
        RacingCar bestPositionCar = racingCarBucket.get(ANY_INDEX);
        for (RacingCar racingCar : racingCarBucket) {
            bestPositionCar = compareCarWithPosition(bestPositionCar, racingCar);
        }

        List<String> winnerNameBucket = new ArrayList<>();
        for (RacingCar racingCar : racingCarBucket) {
            if (racingCar.isSamePosition(bestPositionCar)) {
                winnerNameBucket.add(racingCar.getName());
            }
        }
        return winnerNameBucket;
    }
}
