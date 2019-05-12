package racing.view;

import racing.game.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    static final String CARNAMES_ERROR = "입력형식이 틀렸습니다. 쉼표로 구분된 6자 미만의 이름들을 입력해 주세요.";
    static final String ROUND_NUMBER_ERROR = "1 이상의 정수를 입력해 주세요.";

    public static void showNamesError() {
        System.out.println(CARNAMES_ERROR);
    }

    public static void showRoundNumError() {
        System.out.println(ROUND_NUMBER_ERROR);
    }

    public static void showCarsPosition(List<Car> cars) {
        System.out.println();
        for (Car car : cars) {
            System.out.println(car.toString());
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

}
