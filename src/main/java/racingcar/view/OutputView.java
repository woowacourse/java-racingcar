package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;

public class OutputView {
    private static final String RESULT_SUBJECT = "실행 결과";
    private static final String WINNERS_SUFFIX = "%s가 최종 우승했습니다.";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String CAR_STATUS_PATTERN = "%s : %s";
    private static final String CAR_POSITION_SYMBOL = "-";

    private OutputView() {
        // 인스턴스 생성 방지용
    }

    public static void printResultSubject() {
        System.out.println();
        System.out.println(RESULT_SUBJECT);
    }

    public static void printResults(final List<List<CarStatus>> results) {
        results.forEach(OutputView::printResult);
    }

    private static void printResult(final List<CarStatus> result) {
        result.stream()
                .map(OutputView::makeCarStatusResult)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String makeCarStatusResult(final CarStatus carStatus) {
        return String.format(CAR_STATUS_PATTERN, carStatus.name(), makeCarPositionResult(carStatus.position()));
    }

    private static String makeCarPositionResult(final int position) {
        return CAR_POSITION_SYMBOL.repeat(position);
    }

    public static void printWinners(final List<String> winners) {
        System.out.printf(WINNERS_SUFFIX, String.join(WINNERS_DELIMITER, winners));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
