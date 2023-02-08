package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void initResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceResult(Map<String, Integer> result) {
        result.forEach((key, value) -> System.out.println(key + " : " + "-".repeat(value)));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(winners.stream().collect(Collectors.joining(", ", "", "가 최종 우승했습니다.")));
    }

    public void printError(String errMessage) {
        System.out.println("[ERROR] " + errMessage);
    }
}
