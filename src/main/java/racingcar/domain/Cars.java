package racingcar.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.RacingCarError;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    private static final int ZERO_VALUE = 0;
    private static final int UPPER_LIMIT = 5;

    public Cars(List<String> carNameList) {
        checkNames(carNameList);
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public void processOneTurn() {
        carList.forEach(car -> car.oneTurn(RandomNumberGenerator.turnNumber()));
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return carList.stream()
            .filter(carElement -> (carElement.isSamePosition(maxPosition)))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public static void checkNames(List<String> nameCandidates) {
        checkOverlappedNames(nameCandidates);
        checkNameLength(nameCandidates);
        checkNull(nameCandidates);
    }

    private static void checkOverlappedNames(List<String> nameCandidates) {
        Set<String> targetSet = new HashSet<>(nameCandidates);
        if (nameCandidates.size() != targetSet.size()) {
            RacingCarError.overlapped();
        }
    }

    private static void checkNameLength(List<String> nameCandidates) {
        List<Integer> namesLength = nameCandidates.stream()
            .map(String::length)
            .collect(Collectors.toList());

        for (Integer nameLength : namesLength) {
            checkLowerLimit(nameLength);
            checkUpperLimit(nameLength);
        }
    }

    private static void checkUpperLimit(Integer nameLength) {
        if (nameLength > UPPER_LIMIT) {
            RacingCarError.upperLength();
        }
    }

    private static void checkLowerLimit(Integer nameLength) {
        if (nameLength <= ZERO_VALUE) {
            RacingCarError.lowerLength();
        }
    }

    private static void checkNull(List<String> nameCandidates) {
        if (nameCandidates.size() == ZERO_VALUE) {
            RacingCarError.nullCar();
        }
    }

    public List<Car> getList() {
        return this.carList;
    }
}