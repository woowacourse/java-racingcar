package domain;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int MAX_INPUT_LENGTH = 10_000_000;
    private static final int RANDOM_UPPER_BOUND=10;
    private static final String INVALID_INPUT_LENGTH_MESSAGE = "입력값은 최대 1000만 글자여야 합니다";

    private final List<Car> cars = new ArrayList<>();


    private Cars(String names) {
        validate(names);
        init(names);
    }

    public static Cars from(String names) {
        return new Cars(names);
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> car.move(random.nextInt(RANDOM_UPPER_BOUND)));
    }

    public List<String> winners() {
        Car winner=cars.stream().max(Car::compareTo).get();

        return cars.stream()
                .filter(car->car.compareTo(winner)==0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validate(String names) {
        if (names.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }
    }

    private void init(String input) {
        parseInput(input).stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    private List<String> parseInput(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
