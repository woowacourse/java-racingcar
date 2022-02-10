package racingcar;

import static java.lang.String.join;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}