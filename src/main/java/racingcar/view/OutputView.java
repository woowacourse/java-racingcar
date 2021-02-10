package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void askTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void showStates(Map<String, Integer> states) {
        for (String name : states.keySet()) {
            System.out.println(name + " : " + repeat("-", states.get(name)));
        }
        System.out.println();
    }

    private String repeat(String str, int num) {
        return new String(new char[num]).replace("\0", str);
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
