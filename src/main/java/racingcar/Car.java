package racingcar;

import java.util.Random;

public class Car {
    static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void move(MovableStrategy cond) {
        if (cond.isMove()) {
            position++;
        }
    }

    public interface MovableStrategy {
        boolean isMove();
    }

    static public class RandomMovement implements MovableStrategy {
        public boolean isMove(){
            final int MAX_RAND = 10;
            Random random = new Random();
            return random.nextInt(MAX_RAND) >= MOVE_THRESHOLD;
        }
    }

}
