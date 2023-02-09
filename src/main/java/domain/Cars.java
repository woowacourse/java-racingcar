package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int MAX_INPUT_LENGTH = 10_000_000;
    private static final int RANDOM_UPPER_BOUND = 10;
    private static final String INVALID_INPUT_LENGTH_MESSAGE = "입력값은 최대 1000만 글자여야 합니다";
    private static final String DUPLICATE_CAR_NAMES = "차 이름은 중복될 수 없습니다";

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

    public List<String> getWinners() {
        Car winner = cars.stream().max(Car::compareTo).get();

        return cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getResult() {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getPosition()));

        return result;
    }

    private void validate(String names) {
        if (names.length() > MAX_INPUT_LENGTH)
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);

        //Set<String> duplicationRemoved = new HashSet<>(parseInput(names))
        List<String> splitNames = parseInput(names);
        if (new HashSet<>(splitNames).size() != splitNames.size())
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES);
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
