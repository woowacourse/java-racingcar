package racing.view;

import racing.domain.Race;
import racing.domain.RaceResult;

public class OutputView {
    public static void printRace(final Race race) {
        System.out.println(race);
    }

    public static void printResult(final RaceResult result) {
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public static void printTrialRequest(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printErrMsg(String message) {
        System.out.println(message);
    }
}
