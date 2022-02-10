package racingcar;

import static java.lang.String.join;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String GAME_RESULT_TITLE = "실행 결과";
    private static final String CAR_POSITION_INFO_MESSAGE = "%s : %s";
    private static final String POSITION_BAR = "-";
    private static final String PRINT_WINNER_DELIMITER = ", ";
    private static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public OutputView() {
    }

    public void printGameResultTitle() {
        System.out.println(GAME_RESULT_TITLE);
    }

    public void printCarsPosition(List<RacingCarDto> cars) {
        cars.forEach(this::printCarPosition);
    }

    private void printCarPosition(RacingCarDto car) {
        System.out.printf(CAR_POSITION_INFO_MESSAGE, car.getName(), getCarPosistionBar(car.getPosition()));
    }

    private String getCarPosistionBar(int position) { return IntStream.range(0, position)
            .mapToObj(value -> POSITION_BAR)
            .collect(Collectors.joining());
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(join(PRINT_WINNER_DELIMITER, winnerNames) + PRINT_WINNER_MESSAGE);
    }
}