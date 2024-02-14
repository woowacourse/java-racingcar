package racing.output;

import static java.lang.System.out;

public class InputGuideOutputManager {
    public static void printInputCarNames() {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printInputMaxRacingTurn() {
        out.println("시도할 회수는 몇회인가요?");
    }
}
