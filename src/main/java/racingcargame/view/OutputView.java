package racingcargame.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class OutputView {
    private static final String NOW_RACE_PROGRESS_GUIDE_MESSAGE = "실행 결과";
    private static final String RACE_PROGRESS_OUTPUT_SEPARATOR = " : ";
    private static final String GAME_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_MOVE = "-";
    private static final String CAR_NAME_SEPARATOR = ", ";

    public void showRaceResultMessage() {
        System.out.println(NOW_RACE_PROGRESS_GUIDE_MESSAGE);
    }

    public void showCurrentRaceStatus(HashMap<String, Integer> racingCarsInformation) {
        racingCarsInformation.forEach((racingCarName, racingCarPosition) -> {
            showRacingCarName(racingCarName);
            showRacingCarPosition(racingCarPosition);
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

    public void showWinners(List<String> winners) {
        Queue<String> winner = new LinkedList<>(winners);

        while (winner.size() > 1) {
            System.out.print(winner.poll() + CAR_NAME_SEPARATOR);
        }
        System.out.print(winner.poll() + GAME_WINNER_MESSAGE);
    }

    private void newLine() {
        System.out.println();
    }
}
