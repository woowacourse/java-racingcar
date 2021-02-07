package racingcar.view;

import java.util.List;

public class OutputView {
    public void askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void askTime() {
        System.out.println("\n시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void showState(List<String> states) {
        for (String state : states) {
            System.out.println(state);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
