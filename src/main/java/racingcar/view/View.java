package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.log.GameLog;
import racingcar.domain.log.CarForLog;

public class View {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_VIEW_TITLE_MESSAGE = "실행 결과";
    private static final String WINNER_RESULT_SUFFIX_MESSAGE = "가 최종 우승했습니다.";
    private static final String PROGRESS_BAR = "-";
    private static final String NAME_AND_PROGRESS_BAR_DELIMITER = " : ";
    private static final String WINNER_NAMES_DELIMITER = ", ";

    private static final View view = new View();

    private View() {
    }

    public static View getInstance() {
        return view;
    }

    public void printInputNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printInputTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printResultViewTitle() {
        printBlankLine();
        System.out.println(RESULT_VIEW_TITLE_MESSAGE);
    }

    public void printMidtermResults(GameLog gameLog, int currentTryCount) {
        for (CarForLog carForLog : gameLog.getSingleLog(currentTryCount)) {
            String name = carForLog.getName();
            printCarNameAndProgressBar(name, gameLog.getPositionByName(currentTryCount, name));
        }
        printBlankLine();
    }

    private void printCarNameAndProgressBar(String name, int position) {
        System.out.println(name + NAME_AND_PROGRESS_BAR_DELIMITER + getProgressBar(position));
    }

    private String getProgressBar(int position) {
        return IntStream
                .range(0, position)
                .mapToObj(i -> PROGRESS_BAR)
                .reduce("", (a, b) -> a + b);
    }

    public void printWinnersResult(GameLog gameLog, int totalTryCount) {
        System.out.println(
                getFormattedWinnerNames(gameLog.getWinnerCarNames(totalTryCount)) + WINNER_RESULT_SUFFIX_MESSAGE);
    }

    private String getFormattedWinnerNames(List<String> lastCarNames) {
        return lastCarNames.stream()
                .collect(joining(WINNER_NAMES_DELIMITER));
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private void printBlankLine() {
        System.out.println();
    }
}
