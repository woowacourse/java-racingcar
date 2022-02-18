package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int ANY_INDEX = 0;
    private static final int MINIMUM_CAR_NUMBER = 2;
    private static final String EXCEPTION_NUMBER_OF_CAR = "[ERROR] 경기를 위한 자동차는 최소 2대이상이여야 합니다.";
    private static final String EXCEPTION_ARGUMENT_NULL = "[ERROR] 인자가 null입니다.";
    private static final String EXCEPTION_DUPLICATED_NAME = "[ERROR] 중복된 자동차 이름이 있습니다.";
    private final List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        validateCar(carNames);
        racingCars = carNames.stream()
            .map(RacingCar::new)
            .collect(Collectors.toList());
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
        List<String> noDuplicatedCarNames = carNames.stream()
            .distinct().collect(Collectors.toList());
        if (noDuplicatedCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATED_NAME);
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

    public List<String> getWinnerNames() {
        RacingCar bestPositionCar = findBestPositionCar();
        return racingCars.stream()
            .filter(bestPositionCar::isSamePosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private RacingCar findBestPositionCar() {
        return racingCars.stream()
            .max(RacingCar::compareTo)
            .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_ARGUMENT_NULL));
    }

}
