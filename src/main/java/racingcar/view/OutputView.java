package racingcar.view;

import java.util.List;

public class OutputView {

    public static void startMessage() {
        printLine();
        System.out.println("실행 결과");
    }

    public static void printProgress(String carName, int position) {
        String positionSign = "-".repeat(position);

        System.out.println(carName + " : " + positionSign);
    }

    public static void printWinners(List<String> winners) {
        System.out.print("\n" + String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
