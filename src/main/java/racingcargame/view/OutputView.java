package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.RacingCars;
import racingcargame.domain.Winners;

import java.util.List;

public class OutputView {
    private static final String DISTANCE = "-";

    public static void printWinners(Winners winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", winners.getNames()));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

    public static String printPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(DISTANCE);
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String printPosition(RacingCars cars) {
        List<Car> racingCars = cars.getUnmodifiableCars();
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            sb.append(OutputView.printPosition(car));
        }
        return sb.toString();
    }
}
