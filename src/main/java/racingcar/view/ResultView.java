package racingcar.view;

import racingcar.model.score.Score;
import racingcar.model.score.ScoreBoard;

import java.util.List;

public class ResultView {
    private static final String BEFORE_GAME_RESULT_MESSAGE = "실행 결과";
    private static final String JOIN_DELIMITER = ", ";
    private static final String WINNERS_RESULT_SUFFIX = "가 최종 우승했습니다.";
    private static final String SUFFIX_PRINT_RESULT_CAR_NAME = " : ";
    private static final String CAR_POSITION_STATUS_EXPRESSION = "-";

    public static void printGameResult(List<ScoreBoard> scoreBoards) {
        printBeforeGameResult();
        for (ScoreBoard scoreBoard : scoreBoards) {
            printScoreBoard(scoreBoard.getScores());
        }
    }

    private static void printScoreBoard(List<Score> scores) {
        for (Score score : scores) {
            System.out.println(score.getName() + SUFFIX_PRINT_RESULT_CAR_NAME
                    + CAR_POSITION_STATUS_EXPRESSION.repeat(score.getPoint()));
        }
        printEmptyLine();
    }

    public static void printWinners(List<String> names) {
        System.out.println(String.join(JOIN_DELIMITER, names) + WINNERS_RESULT_SUFFIX);
    }

    public static void printBeforeGameResult() {
        printEmptyLine();
        System.out.println(BEFORE_GAME_RESULT_MESSAGE);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
