package view;

import java.util.List;
import java.util.stream.Collectors;
import model.dto.CarState;
import model.dto.Winner;

public class OutputView {
    private String formatCapturedCarStates(List<CarState> carStates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CarState carState : carStates) {
            stringBuilder.append(carState.name());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(carState.forwardCount()));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String formatWinners(List<Winner> winners) {
        return winners.stream().map(winner -> winner.name())
                .collect(Collectors.joining(", "));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPlayResult() {
        System.out.println("\n실행 결과");
    }

    public void printCapturedCarStates(List<CarState> carStates) {
        System.out.println(formatCapturedCarStates(carStates));
    }

    public void printFinalResult(List<Winner> winners) {
        System.out.println(formatWinners(winners) + "가 최종 우승했습니다.");
    }
}
