package view;

import domain.GameResult;
import dto.CarStatus;
import dto.TurnResult;
import dto.WinnersResponse;
import java.util.List;
import view.Printer.Printer;

public class OutputView {
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void showResult(WinnersResponse rawWinners) {
        List<String> winners = rawWinners.getNames();
        String result = String.join(",", winners);
        printer.printLine(result + "가 최종 우승했습니다.");
    }

    public void showStatusMessage() {
        printer.printLine("실행 결과");
    }

    public void showStatus(GameResult result) {
        result.getGameResult().forEach(this::showResult);
    }

    private void showResult(TurnResult turnResult) {
        for (CarStatus carStatus : turnResult.getCarStatuses()) {
            String mark = "-".repeat(carStatus.getDistance());
            printer.printLine("%s : %s", carStatus.getName(), mark);
        }
        printer.printEmptyLine();
    }
}
