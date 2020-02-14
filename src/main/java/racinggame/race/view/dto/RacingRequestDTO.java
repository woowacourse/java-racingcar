package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;
import racinggame.race.car.engine.Engine;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingRequestDTO {
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final int MINIMUM_COUNT = 1;
    private static final String MINIMUM_COUNT_EXCEPTION_MESSAGE = "시도 횟수는 0보다 커야합니다.";
    private static final String EMPTY_NAMES_EXCETPION_MESSAGE = "입력값이 비어 있습니다.";

    private final List<String> names;
    private final int count;

    public RacingRequestDTO(String names, int count) {
        validate(names, count);
        this.names = Arrays.stream(names.split(COMMA))
                .map(String::trim)
                .collect(toList());
        this.count = count;
    }

    private void validate(String names, int count) {
        validateNames(names);
        validateCount(count);
    }

    private void validateNames(String names) {
        if (isEmpty(names)) {
            throw new IllegalArgumentException(EMPTY_NAMES_EXCETPION_MESSAGE);
        }
    }

    private boolean isEmpty(String names) {
        return names == null || names.trim().equals(BLANK);
    }

    private void validateCount(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException(MINIMUM_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public List<String> getNames() {
        return unmodifiableList(this.names);
    }

    public int getCount() {
        return count;
    }

    public Cars toCars(Engine engine) {
        return this.names.stream()
                .map(name -> new Car(name, engine))
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
