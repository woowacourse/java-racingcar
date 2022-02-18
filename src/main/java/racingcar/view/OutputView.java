package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.CarDto;

public class OutputView {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_INFO_SEPARATOR = " : ";
    private static final String CAR_POSITION_BAR = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printRaceResults(Map<Integer, List<CarDto>> raceResult) {
        System.out.println(ROUND_RESULT);
        for (Integer round : raceResult.keySet()) {
            raceResult.get(round).forEach(OutputView::printCarPositionInfo);
            System.out.println();
        }
    }

    private static void printCarPositionInfo(CarDto carDto) {
        System.out.println(
                carDto.getName() + CAR_INFO_SEPARATOR + CAR_POSITION_BAR.repeat(Math.max(0, carDto.getPosition())));
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(joinWinnerNames(winnerNames) + WINNER_MESSAGE);
    }

    private static String joinWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_NAME_DELIMITER, winnerNames);
    }
}
