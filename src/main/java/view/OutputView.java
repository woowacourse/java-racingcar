package view;

import java.util.List;

public class OutputView {
    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printMovement(List<String> movement) {
        System.out.println(String.join("\n", movement));
        System.out.println();
    }
}
