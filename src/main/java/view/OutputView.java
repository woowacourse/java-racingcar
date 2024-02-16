package view;

import dto.CarStatus;
import dto.TurnStatus;
import dto.WinnersResponse;
import java.util.List;
import view.Printer.Printer;

public class OutputView {
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void showStatusMessage() {
        printer.printLine("실행 결과");
    }

//
//    public void showStatus(TurnsStatus result) {
//        result.getGameResult().forEach(this::showResult);
//    }
public void showTurnResult(TurnStatus turnStatus) {
        for (CarStatus carStatus : turnStatus.getCarStatuses()) {
            String mark = "-".repeat(carStatus.getDistance());
            printer.printLine("%s : %s", carStatus.getName(), mark);
        }
        printer.printEmptyLine();
    }

    public void showWinners(WinnersResponse rawWinners) {
        List<String> winners = rawWinners.getNames();
        String result = String.join(",", winners);
        printer.printLine(result + "가 최종 우승했습니다.");
    }
}
