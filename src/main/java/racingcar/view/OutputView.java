package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.dto.CarDto;

public class OutputView {
    private static final String GAME_RESULT_TITLE = "\n실행 결과";

    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String CAR_POSITION_FORMAT = "%s : %s\n";

    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String POSITION_CHARACTOR = "-";

    public static void printGameResultTitle() {
        System.out.println(GAME_RESULT_TITLE);
    }

    public static void printCarPosition(List<CarDto> cars) {
        cars.forEach(car -> System.out.printf(
                CAR_POSITION_FORMAT, car.getName(), POSITION_CHARACTOR.repeat(car.getPosition())));
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printWinner(List<CarDto> winners) {
        final List<String> winnerNames = winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
        System.out.printf(WINNER_FORMAT, String.join(WINNER_NAME_DELIMITER, winnerNames));
    }
}
