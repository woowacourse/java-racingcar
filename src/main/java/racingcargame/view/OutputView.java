package racingcargame.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import racingcargame.dto.CarDto;

public class OutputView {
    private static final String NOW_RACE_PROGRESS_GUIDE_MESSAGE = "실행 결과";
    private static final String RACE_PROGRESS_OUTPUT_SEPARATOR = " : ";
    private static final String GAME_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_MOVE = "-";
    private static final String CAR_NAME_SEPARATOR = ", ";

    public void showRaceResultMessage() {
        System.out.println(NOW_RACE_PROGRESS_GUIDE_MESSAGE);
    }

    public void showCurrentRaceStatus(List<CarDto> racingCarsInformation) {
        racingCarsInformation.forEach((racingCarInformation) -> {
            showRacingCarName(racingCarInformation.getName());
            showRacingCarPosition(racingCarInformation.getPosition());
        });
        newLine();
    }

    private void showRacingCarName(String racingCarName) {
        System.out.print(racingCarName + RACE_PROGRESS_OUTPUT_SEPARATOR);
    }

    private void showRacingCarPosition(int racingCarPosition) {
        IntStream.range(0, racingCarPosition).forEach(index -> System.out.print(CAR_MOVE));
        newLine();
    }

    public void showWinners(List<CarDto> winners) {
        final StringJoiner winnerNames = new StringJoiner(", ");
        winners.forEach(winner -> winnerNames.add(winner.getName()));
        System.out.println(winnerNames);
    }

    private void newLine() {
        System.out.println();
    }
}
