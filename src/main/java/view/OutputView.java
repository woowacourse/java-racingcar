package view;

import java.util.List;
import model.CarState;

public class OutputView {
    public void printPlayResult() {
        System.out.println("실행 결과");
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
}
