package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.NameValidator;

public class Cars {

    private final List<Car> carList;
    private int winnerPosition = 0;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createByNames(String[] names) {
        NameValidator.isDuplicatedNames(names);
        return new Cars(Arrays.stream(names)
            .map(Car::createByName)
            .collect(Collectors.toList()));
    }

    public void tryMoveCars() {
        this.carList.forEach(Car::tryToMove);
        updateWinnerPosition();
    }

    private void updateWinnerPosition() {
        this.carList.forEach(car -> winnerPosition = Math.max(winnerPosition, car.getPosition()));
    }

    public String[] getWinners() {
        return this.carList.stream()
            .filter(car -> car.isInWinnerPosition(winnerPosition))
            .map(Car::getName)
            .toArray(String[]::new);
    }

    public String getAllCarsPosition() {
        return this.carList.stream().map(Car::toString).collect(Collectors.joining("\n"));
    }
}
