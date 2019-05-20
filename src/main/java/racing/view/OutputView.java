package racing.view;

import racing.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String RESULT_IS = "실행 결과";
    private static final String POSITION_CHARACTER = "-";

    public static void showCarsPosition(List<Car> cars) {
        System.out.println();
        for (Car car : cars
        ) {
            showSingleCarPosition(car);
        }
    }

    private static void showSingleCarPosition(Car car) {
        int position = car.getPosition();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_CHARACTER);
        }
    }

    public static void showChampion(List<Car> winners) {
        System.out.println();
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Car winner : winners) {
            stringJoiner.add(winner.getName());
        }
        System.out.println(stringJoiner.toString() + "가 최종 우승했습니다.");
    }

    public static void printStartTheGame() {
        System.out.print(RESULT_IS);
    }
}
