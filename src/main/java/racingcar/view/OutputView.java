package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void showResult() {
        System.out.println("\n실행 결과");
    }

    public static void showRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showWinner(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
