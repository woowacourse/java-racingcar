package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Cars {

    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;

    private final List<Car> carList;
    private int winnerPosition = 0;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createByNames(String[] names) {
        isDuplicatedNames(names);
        return new Cars(Arrays.stream(names)
            .map(Car::createByName)
            .collect(Collectors.toList()));
    }

    public static void isDuplicatedNames(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }

    public void tryMoveCars() {
        this.carList.forEach(c -> c.tryMove(generateRandomNumber()));
    }

    private void updateWinnerPosition() {
        this.carList.forEach(car -> winnerPosition = car.greaterPosition(winnerPosition));
    }

    public String[] getWinners() {
        updateWinnerPosition();
        return this.carList.stream()
            .filter(car -> car.isInWinnerPosition(winnerPosition))
            .map(Car::getName)
            .toArray(String[]::new);
    }

    public String getAllCarsPosition() {
        return this.carList.stream().map(Car::getPositionStatus).collect(Collectors.joining("\n"));
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
    }
}
