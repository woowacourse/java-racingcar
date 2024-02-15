package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final int count;
    private final List<Car> cars;

    public Race(int count, List<Car> cars) {
        this.count = count;
        this.cars = cars;
    }

    public String play() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(getResults())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private String getResults() {
        List<String> results = new ArrayList<>();
        cars.forEach(car -> {
            car.move(RandomGenerator.getRandomNumber());
            results.add(car.getResult());
        });
        return String.join("", results);
    }
}
