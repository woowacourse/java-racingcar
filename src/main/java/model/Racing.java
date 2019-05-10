package model;

import java.util.Random;

public class Racing {
    private static final int SEED = 10;
    private static final int BOUND = 4;

    void move(Car car) {
        Random random = new Random();

        if (isMove(random.nextInt(SEED))) {
            int position = car.getPosition();
            car.setPosition(++position);
        }
    }

    boolean isMove(int number) {
        return number >= BOUND;
    }
}
