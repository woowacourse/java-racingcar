package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();

    public void run() {
        InputView.inputCarNames().forEach(x -> cars.add(new Car(x)));
        int numberOfTimes = InputView.inputNumberOfTimes();

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTimes; ++i) {
            cars.forEach(car -> car.moveOrNot());
            cars.forEach(car -> OutputView.printCarDistance(car));
            System.out.println();
        }

        OutputView.printWinners(String.join(", ", Winner.getWinners(cars)));
    }
}
