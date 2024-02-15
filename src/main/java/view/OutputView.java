package view;

import java.util.List;
import model.dto.CarState;

public class OutputView {
    public void printPlayResult() {
        System.out.println("\n실행 결과");
    }

    public void printCapturedCarStates(List<CarState> carStates) {
        System.out.println(formatCapturedCarStates(carStates));
    }

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

    public void printFinalResult(List<String> winners) {
        System.out.println(formatWinners(winners) + "가 최종 우승했습니다.");
    }

    private String formatWinners(List<String> winners) {
        return String.join(", ", winners);
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
