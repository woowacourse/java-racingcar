package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();
    private List<Car> cars = new ArrayList<>();

    public void run() {
        InputView.inputCarNames().forEach(x -> cars.add(new Car(x)));
        for (int i = 0; i < InputView.inputNumberOfTimes(); ++i) {

        }
    }

    private void move(Car car) {
        car.moveOrNot(random.nextInt(10));
    }
}
