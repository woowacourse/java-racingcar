package racingcargame.view;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import racingcargame.dto.CarDto;

public class OutputView {
    private static final String RACE_RESULT_GUIDE_MESSAGE = "실행 결과";
    private static final String RACING_CAR_NAME_SEPARATOR = " : ";
    private static final String GAME_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_POSITION_SYMBOL = "-";

    public void showRaceResultMessage() {
        System.out.println(RACE_RESULT_GUIDE_MESSAGE);
    }

    public void showCurrentRaceResult(final List<CarDto> racingCarsInformation) {
        racingCarsInformation.forEach((racingCarInformation) -> {
            showRacingCarName(racingCarInformation.getName());
            showRacingCarPosition(racingCarInformation.getPosition());
        });
        newLine();
    }

    private void showRacingCarName(final String racingCarName) {
        System.out.print(racingCarName + RACING_CAR_NAME_SEPARATOR);
    }

    private void showRacingCarPosition(final int racingCarPosition) {
        IntStream.range(0, racingCarPosition).
                forEach(index -> System.out.print(CAR_POSITION_SYMBOL));
        newLine();
    }

    public void showRaceWinners(final List<CarDto> winners) {
        final StringJoiner winnerNames = new StringJoiner(", ");
        winners.forEach(winner -> winnerNames.add(winner.getName()));
        System.out.println(winnerNames + GAME_WINNER_MESSAGE);
    }

    private void newLine() {
        System.out.println();
    }
}
