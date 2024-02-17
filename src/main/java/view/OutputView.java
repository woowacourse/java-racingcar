package view;

import domain.Winners;
import dto.CarStatus;
import dto.TurnResult;
import java.util.List;

public class OutputView {
    public void showResult(List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void showStatusMessage() {
        System.out.println("실행 결과");
    }

    public void showStatus(List<TurnResult> result) {
        for (TurnResult turnResult : result) {
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
