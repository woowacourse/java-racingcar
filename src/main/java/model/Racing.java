package model;

import java.util.Random;

public class Racing {
    static final int SEED = 11;
    static final int BOUND = 4;

    void move(Car car) {
        Random random = new Random(SEED);        
        int position = car.getPosition();

        if (random.nextInt() >= BOUND) {
            car.setPosition(++position);
        }
    }
}
