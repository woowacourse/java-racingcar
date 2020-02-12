package racingcargame.view.output;

import racingcargame.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printRoundEach(car);
        }
    }

    private static void printRoundEach(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(": ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
