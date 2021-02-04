package racingcar.view;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void output(String message){
        System.out.println(message);
    }

    public static void printLeaderBoard(List<Car> cars) {
        for (Car car : cars) {
            String positionStick = String.join("", Collections.nCopies(car.getPosition(), "-"));
            System.out.println(String.format("%s : %s", car.getName(), positionStick));
        }
        System.out.println();
    }
}
