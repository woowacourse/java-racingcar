package view;

import java.util.List;

public class OutputView {
    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printCarsMovement(List<String> movement) {
        System.out.println(String.join("\n", movement));
        System.out.println();
    }
}
