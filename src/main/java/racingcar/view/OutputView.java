package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printResultSubject() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(final List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinners(final List<String> winners) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winners));
    }
}
