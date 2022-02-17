package racingcar.domain;

import racingcar.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final int ANY_INDEX = 0;
    private static final int MINIMUM_CAR_NUMBER = 2;
    private static final String EXCEPTION_NUMBER_OF_CAR = "[ERROR] 경기를 위한 자동차는 최소 2대이상이여야 합니다.";
    private static final String EXCEPTION_ARGUMENT_NULL = "[ERROR] 인자가 null입니다.";
    private final List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        validateCar(carNames);
        racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    private void validateCar(List<String> carNames) {
        checkArgumentIsNull(carNames);
        checkNumberOfCar(carNames);
        checkDuplicatedCarNameExist(carNames);
    }

    private void checkArgumentIsNull(List<String> argument) {
        if (argument == null) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_NULL);
        }
    }

    private void checkNumberOfCar(List<String> carNames) {
        if (carNames.size() < MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_OF_CAR);
        }
    }

    private void checkDuplicatedCarNameExist(List<String> carNames) {
        for (String name : carNames) {
            checkNameExistMoreThanOne(name, carNames);
        }
    }

    private void checkNameExistMoreThanOne(String sourceName, List<String> carNames) {
        int numberOfName = 0;
        for (String targetName : carNames) {
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
        for (RacingCar racingCar : racingCars) {
            racingCar.goOrStay(RandomGenerator.generateRandomNumber());
        }
    }

    public List<String> getCurrentRaceState() {
        List<String> currentRaceState = new ArrayList<>();
        for (RacingCar racingCar: racingCars) {
            currentRaceState.add(racingCar.currentState());
        }
        return currentRaceState;
    }

    private RacingCar compareCarWithPosition(RacingCar sourceCar, RacingCar targetCar) {
        return sourceCar.compareCar(targetCar);
    }

    public List<String> getWinnerNames() {
        RacingCar bestPositionCar = racingCars.get(ANY_INDEX);
        for (RacingCar racingCar : racingCars) {
            bestPositionCar = compareCarWithPosition(bestPositionCar, racingCar);
        }

        List<String> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            winnerNames = updateWinnerNames(winnerNames, bestPositionCar, racingCar);
        }
        return winnerNames;
    }

    private List<String> updateWinnerNames(List<String> winnerNames,
        RacingCar bestPositionCar, RacingCar racingCar) {
        if (racingCar.isSamePosition(bestPositionCar)) {
            winnerNames.add(racingCar.getName());
        }
        return winnerNames;
    }
}
