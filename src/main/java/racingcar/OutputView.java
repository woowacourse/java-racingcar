package racingcar;

import java.util.List;

public class OutputView {
    public void printResultPrompt() {
        System.out.println("실행 결과");
    }

    public void printResult(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
