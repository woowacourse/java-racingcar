package model;

import java.util.Random;

public class Racing {
    private static final int RANDOM_BOUND = 10;
    private Cars cars;

    public Racing (Cars cars) {
        this.cars = cars;
    }

    public void run() {
        for (Car car : cars.getCars()) {
            Random random = new Random();
            car.move(random.nextInt(RANDOM_BOUND));
        }
    }
}
