package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printResultSubject() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

}
