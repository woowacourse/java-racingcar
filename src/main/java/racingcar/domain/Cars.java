package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Cars {
    private static final int MIN_VALUE_LENGTH = 2;

    private final List<Car> value;

    public Cars(final List<Car> value) {
        validateValueLength(value);
        validateDuplication(value);
        this.value = value;
    }

    static void validateValueLength(final List<Car> value) {
        if (value.size() < MIN_VALUE_LENGTH) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    static void validateDuplication(final List<Car> value) {
        final HashSet<Car> nonDuplicatedValue = new HashSet<>(value);
        if (nonDuplicatedValue.size() != value.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    public void tryToMove() {
        for (Car car : value) {
            final int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
        }
    }

    public int findMaxPosition() {
        return value.stream().map(Car::getPosition).reduce(Integer::max).orElse(-1);
    }

    public List<String> findCarNamesLocatedAt(int position) {
        return value.stream().filter(car -> car.getPosition() == position).map(Car::getName).collect(
            Collectors.toList());
    }

    public List<Car> getValue() {
        return value;
    }
}
