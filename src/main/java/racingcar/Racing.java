package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();
    private List<Car> cars = new ArrayList<>();

    public void run() {
        InputView.inputCarNames().forEach(x -> cars.add(new Car(x)));
        int numberOfTimes = InputView.inputNumberOfTimes();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTimes; ++i) {
            cars.forEach(car -> move(car));
            cars.forEach(car -> OutputView.printCarDistance(car));
            System.out.println();
        }
    }

    private void move(Car car) {
        car.moveOrNot(random.nextInt(10));
    }
}
