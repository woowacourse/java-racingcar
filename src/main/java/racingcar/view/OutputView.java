package racingcar.view;

import racingcar.domian.Car;

import java.util.List;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printCurrentRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
