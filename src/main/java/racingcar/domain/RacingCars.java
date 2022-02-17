package racingcar.domain;

import racingcar.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final int ANY_INDEX = 0;
    private static final int MINIMUM_CAR_NUMBER = 2;
    private static final String EXCEPTION_NUMBER_OF_CAR = "[ERROR] 경기를 위한 자동차는 최소 2대이상이여야 합니다.";
    private final List<RacingCar> racingCarBucket;

    public RacingCars(List<String> carNameBucket) {
        validateCar(carNameBucket);
        racingCarBucket = new ArrayList<>();
        for (String name : carNameBucket) {
            racingCarBucket.add(new RacingCar(name));
        }
    }

    private void validateCar(List<String> carNameBucket) {
        checkNumberOfCar(carNameBucket);
        checkDuplicatedCarNameExist(carNameBucket);
    }

    private void checkNumberOfCar(List<String> carNameBucket) {
        if (carNameBucket.size() < MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_OF_CAR);
        }
    }

    private void checkDuplicatedCarNameExist(List<String> carNameBucket) {
        for (String name : carNameBucket) {
            checkNameExistMoreThanOne(name, carNameBucket);
        }
    }

    private void checkNameExistMoreThanOne(String sourceName, List<String> carNameBucket) {
        int numberOfName = 0;
        for (String targetName : carNameBucket) {
            numberOfName += isNameSame(sourceName, targetName);
        }
        checkNumberOfNameOverLimit(numberOfName);
    }

    private int isNameSame(String sourceName, String targetName) {
        if (sourceName.equals(targetName)) {
            return 1;
        }
        return 0;
    }

    private void checkNumberOfNameOverLimit(int number) {
        if (number < MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_OF_CAR);
        }
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
            winnerNameBucket = updateWinnerNameBucket(winnerNameBucket, bestPositionCar, racingCar);
        }
        return winnerNameBucket;
    }

    private List<String> updateWinnerNameBucket(List<String> winnerNameBucket,
        RacingCar bestPositionCar, RacingCar racingCar) {
        if (racingCar.isSamePosition(bestPositionCar)) {
            winnerNameBucket.add(racingCar.getName());
        }
        return winnerNameBucket;
    }
}
