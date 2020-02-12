package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public static final String GAGE = "-";
    public static final String COLON = " : ";
    public static final String COMMA = ", ";

    public static void showResult() {
        System.out.println("\n실행 결과");
    }

    public static void showRace(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();

            String resultOfMovement = Stream.generate(() -> GAGE)
                    .limit(car.getPosition())
                    .collect(Collectors.joining(InputView.EMPTY));

            System.out.println(String.join(COLON, carName, resultOfMovement));
        }
        System.out.println();
    }

    public static void showWinner(List<String> winners) {
        System.out.print(String.join(COMMA, winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
