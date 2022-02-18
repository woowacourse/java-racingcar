package racingcar.view;

import static java.lang.String.join;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.controller.RacingCarDto;

public class OutputView {

    private static final String GAME_RESULT_TITLE = "\n실행 결과";
    private static final String CAR_POSITION_INFO_MESSAGE = "%s : %s";
    private static final String POSITION_BAR = "-";
    private static final String PRINT_WINNER_DELIMITER = ", ";
    private static final String PRINT_WINNER_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printGameResultTitle() {
        System.out.println(GAME_RESULT_TITLE);
    }

    public static void printCarsPosition(final List<RacingCarDto> racingCarDtos) {
        racingCarDtos.forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(final RacingCarDto racingCarDto) {
        System.out.printf(CAR_POSITION_INFO_MESSAGE, racingCarDto.getName(), getCarPositionBar(racingCarDto.getPosition()));
        System.out.println();
    }

    private static String getCarPositionBar(final int position) {
        return IntStream.range(0, position)
            .mapToObj(value -> POSITION_BAR)
            .collect(Collectors.joining());
    }

    public static void printWinnerNames(final List<String> winnerNames) {
        System.out.println(join(PRINT_WINNER_DELIMITER, winnerNames) + PRINT_WINNER_MESSAGE);
    }
}