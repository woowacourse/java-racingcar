package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void initResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceResult(Map<String, Integer> result) {
        result.forEach((name, position) -> System.out.println(formatAsResult(name, position)));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(formatAsWinners(winners));
    }

    public void printError(String errMessage) {
        System.out.println("[ERROR] " + errMessage);
    }

    private String formatAsResult(String name, Integer position) {
        return name + " : " + "-".repeat(position);
    }

    private String formatAsWinners(List<String> winners) {
        return winners.stream().collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
    }
}
