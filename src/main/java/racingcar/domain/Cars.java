package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class Cars {

    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;

    private final List<Car> cars;
    private int winnerPosition = 0;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByNames(String[] names) {
        checkDuplicatedNames(names);
        return new Cars(Arrays.stream(names)
            .map(Car::createByName)
            .collect(Collectors.toList()));
    }

    public static void checkDuplicatedNames(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("Duplicated Name exception");
        }
    }

    public void tryMoveCars() {
        this.cars.forEach(c -> c.tryMove(generateRandomNumber()));
    }

    private void updateWinnerPosition() {
        this.cars.forEach(car -> winnerPosition = car.greaterPosition(winnerPosition));
    }

    public List<String> getWinners() {
        updateWinnerPosition();
        return this.cars.stream()
            .filter(car -> car.isInWinnerPosition(winnerPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public void printAllCarsPosition() {
        this.cars.forEach(OutputView::printRace);
        OutputView.printLine();
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
    }
}
