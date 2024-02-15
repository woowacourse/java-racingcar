package view;

import domain.GameResult;
import dto.CarStatus;
import dto.TurnResult;
import dto.WinnersResponse;
import java.util.List;

public class OutputView {
    public void showResult(WinnersResponse rawWinners) {
        List<String> winners = rawWinners.getNames();
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void showStatusMessage() {
        System.out.println("실행 결과");
    }

    public void showStatus(GameResult result) {
        for (TurnResult turnResult : result.getGameResult()) {
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
