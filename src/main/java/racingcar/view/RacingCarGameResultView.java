package racingcar.view;

import java.util.List;

public class RacingCarGameResultView {
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public void printFinalResult(final List<String> winnersNames) {
        System.out.println(String.join(", ", winnersNames) + FINAL_RESULT_MESSAGE);
    }
}