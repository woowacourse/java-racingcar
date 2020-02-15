package racingcargame.view.output;

import racingcargame.domain.Car;
import racingcargame.domain.Position;

import java.util.List;

public class OutputView {
    public static final String DISPLAY_POSITION_CHAR = "-";
    public static final String JOIN_CHAR = ",";

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printRoundEach(car);
        }
        System.out.println();
    }

    private static void printRoundEach(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(": ");
        for (int i = 0; i < car.getPosition().getPosition(); i++) {
            sb.append(DISPLAY_POSITION_CHAR);
        }
        System.out.println(sb.toString());
    }

    public static void printWinners(List<String> carNames) {
        String names = String.join(JOIN_CHAR, carNames);
        System.out.println(names + "이(가) 우승하셨습니다.");
    }
}
