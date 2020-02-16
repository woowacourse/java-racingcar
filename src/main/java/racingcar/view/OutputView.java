package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";
    private static final String NAME_POSITION_DELIMITER = ": ";

    public static void printRoundResult(RacingGame racingGame) {
        String carNameAndPosition = racingGame.getRacingCars()
            .stream()
            .map(OutputView::showCarNameAndPosition)
            .collect(Collectors.joining(NEW_LINE));
        System.out.println(carNameAndPosition + NEW_LINE);
    }

    private static String showCarNameAndPosition(Car car) {
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            trace.append(POSITION_MARK);
        }
        return car.getName() + NAME_POSITION_DELIMITER + trace.toString();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다.");
    }

}
