package racingcar.view;

import racingcar.dto.RacingCarDto;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_HEADER = "실행 결과";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NAME_DELIMITER = ", ";
    private static final String ROUND_RESULT_DELIMITER = " : ";
    private static final String CAR_POSITION_DELIMITER = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void printResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public void printRoundResult(List<RacingCarDto> carResults) {
        for (RacingCarDto racingCarDto : carResults) {
            String carResult = racingCarDto.getName() + ROUND_RESULT_DELIMITER + CAR_POSITION_DELIMITER.repeat(racingCarDto.getPosition());
            System.out.println(carResult);
        }
        System.out.println();
    }

    public void printWinners(List<String> winningCarsName) {
        String winners = String.join(NAME_DELIMITER, winningCarsName);
        System.out.println(winners + WINNER_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER + message);
    }
}
