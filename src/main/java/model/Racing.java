package model;

import java.util.Random;

public class Racing {
    private static final int SEED = 11;
    private static final int BOUND = 4;

    void move(Car car) {
        Random random = new Random(SEED);
        int position = car.getPosition();

        if (random.nextInt() >= BOUND) {
            car.setPosition(++position);
        }
    }
}
