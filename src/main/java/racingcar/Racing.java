package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();

    private void move(Car car) {
        car.moveOrNot(random.nextInt(10));
    }
}
