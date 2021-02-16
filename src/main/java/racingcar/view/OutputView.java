package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String POSITION_BAR = "-";

    private OutputView() {
    }

    public static void printInfo(String info) {
        System.out.println(info);
    }

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printRace(Car car) {
        System.out.println(car.getName() + " : " + makePositionBar(car.getPosition()));
    }

    public static String makePositionBar(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION_BAR);
        }
        return sb.toString();
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printLine() {
        System.out.println();
    }
}
