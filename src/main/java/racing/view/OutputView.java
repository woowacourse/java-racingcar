package racing.view;

import racing.domain.Car;
import racing.domain.Race;
import racing.domain.RaceResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputView {
    public static void printResult(final List<String> winnerNames) {
        String joinedNames = String.join(", ",winnerNames);
        System.out.println(String.join("\n", joinedNames + "가 최종 우승했습니다."));
    }

    public static void printTrialRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printProgress(final Race race) {
        System.out.println(race);
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }
}
