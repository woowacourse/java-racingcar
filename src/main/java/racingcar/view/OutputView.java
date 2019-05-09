package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printCarState(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
