package view;

import domain.RaceResult;
import dto.CarStatus;
import dto.TurnResult;
import java.util.List;

public class OutputView {
    public void showResult(List<String> turnResults) {
        String result = String.join(",", turnResults);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void showStatusMessage() {
        System.out.println("실행 결과");
    }

    public void showStatus(RaceResult result) {
        for (TurnResult turnResult : result.getResult()) {
            showResult(turnResult);
        }
    }

    private static void showResult(TurnResult turnResult) {
        for (CarStatus carStatus : turnResult.getCarStatuses()) {
            System.out.println(carStatus.getName() + " : " + "-".repeat(carStatus.getDistance()));
        }
        System.out.println();
    }
}
