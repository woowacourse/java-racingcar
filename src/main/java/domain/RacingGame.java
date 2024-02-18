package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import movestrategy.MoveStrategy;

public class RacingGame {

    private static final int MIN_CAR_AMOUNT = 1;
    private static final int MAX_CAR_AMOUNT = 100;

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(String rawCarNames, MoveStrategy moveStrategy) {
        cars = new ArrayList<>();
        this.moveStrategy = moveStrategy;
        makeCarsFrom(rawCarNames);
    }

    public List<Car> playOneRound() {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
        return cars;
    }

    public List<Car> findWinners() {
        return cars.stream()
            .filter(car -> car.equals(Collections.max(cars)))
            .toList();
    }

    private void makeCarsFrom(String rawCarNames) {
        List<String> carNames = Arrays.stream(rawCarNames.trim().split("\\s*,\\s*", -1)).toList();
        validate(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void validate(List<String> names) {
        validateCarAmount(names);
        validateNameDuplication(names);
    }

    private void validateCarAmount(List<String> names) {
        if (names.isEmpty() || names.size() > MAX_CAR_AMOUNT) {
            throw new IllegalArgumentException(
                "차는 " + MIN_CAR_AMOUNT + " ~ " + MAX_CAR_AMOUNT + "대만 입력 가능합니다.");
        }
    }

    private void validateNameDuplication(List<String> names) {
        Set<String> nonDuplicatedNames = new HashSet<>(names);
        if (nonDuplicatedNames.size() != names.size()) {
            throw new IllegalArgumentException("중복되거나 비어 있는 자동차 이름이 있습니다.");
        }
    }
}
