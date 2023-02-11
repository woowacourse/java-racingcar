package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;
    private static final String DUPLICATED_CAR_NAMES = "차 이름은 중복될 수 없습니다";

    private final List<Car> cars = new ArrayList<>();

    private Cars(List<String> names) {
        validate(names);
        init(names);
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> car.move(random.nextInt(RANDOM_UPPER_BOUND_EXCLUSIVE)));
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

    private void validate(List<String> names) {
        if (new HashSet<>(names).size() != names.size())
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
    }

    private void init(List<String> names) {
        names.stream()
                .map(Car::new)
                .forEach(cars::add);
    }
}
