package domain;

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
            cars.forEach(car -> {
                car.move();
                stringBuilder.append(car.getResult());
            });
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
