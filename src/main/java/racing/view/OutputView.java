package racing.view;

import racing.domain.Car;

import java.util.List;

public class OutputView {

    public static void printBeforeRacing() {
        System.out.println("실행 결과");
    }

    public static void printRacing(final List<Car> result) {
        for (Car car : result) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(final List<String> winnersName) {
        String refined = String.join(", ", winnersName);
        System.out.printf("%s가 최종 우승했습니다.\n", refined);
    }
}
