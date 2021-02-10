package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Cars {

    private static final int VALUE_LENGTH_MIN = 2;
    private static final String NAME_SPLIT_DELIMITER = ",";

    private final List<Car> value;

    public Cars(final List<Car> value) {
        validateValueLength(value);
        validateDuplication(value);
        this.value = new ArrayList<>(value);
    }

    private static void validateValueLength(final List<Car> value) {
        if (value.size() < VALUE_LENGTH_MIN) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    private static void validateDuplication(final List<Car> value) {
        final HashSet<Car> nonDuplicatedValue = new HashSet<>(value);
        if (nonDuplicatedValue.size() != value.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    public static Cars getInstance(final String input) {
        final String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        return new Cars(Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public void tryToMove() {
        for (Car car : value) {
            final int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
        }
    }

    public int findPositionMax() {
        return value.stream().map(Car::getPosition).reduce(Integer::max).orElse(-1);
    }

    public List<String> findCarNamesLocatedAt(int position) {
        return value.stream().filter(car -> car.getPosition() == position).map(Car::getName)
            .collect(
                Collectors.toList());
    }

    public List<Car> getValue() {
        return new ArrayList<>(value);
    }
}
