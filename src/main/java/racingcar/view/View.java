package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.Scanner;
import java.util.stream.IntStream;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

public class View {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_VIEW_TITLE_MESSAGE = "실행 결과";
    private static final String WINNER_RESULT_SUFFIX_MESSAGE = "가 최종 우승했습니다.";
    private static final String PROGRESS_BAR = "-";
    private static final String NAME_AND_PROGRESS_BAR_DELIMITER = " : ";
    private static final String WINNER_NAMES_DELIMITER = ", ";

    private Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public void printResultViewTitle() {
        printBlankLine();
        System.out.println(RESULT_VIEW_TITLE_MESSAGE);
    }

    public void printMidtermResults(MidtermResult midtermResult) {
        for (String name : midtermResult.getCarNames()) {
            printCarNameAndProgressBar(name, midtermResult.getPositionByName(name));
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

    public void printWinnerResult(WinnersResult winnersResult) {
        System.out.println(getFormattedWinnerNames(winnersResult) + WINNER_RESULT_SUFFIX_MESSAGE);
    }

    private String getFormattedWinnerNames(WinnersResult winnersResult) {
        return winnersResult.getWinnerNames().stream()
                .collect(joining(WINNER_NAMES_DELIMITER));
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
