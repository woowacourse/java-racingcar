package view;

import dto.CarReponse;
import dto.CarsReponse;
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

public void showTurnResult(CarsReponse carsReponse) {
        for (CarReponse carReponse : carsReponse.getCarsReponses()) {
            String mark = "-".repeat(carReponse.getDistance());
            printer.printLine("%s : %s", carReponse.getName(), mark);
        }
        printer.printEmptyLine();
    }

    public void showWinners(WinnersResponse rawWinners) {
        List<String> winners = rawWinners.getNames();
        String result = String.join(",", winners);
        printer.printLine(result + "가 최종 우승했습니다.");
    }
}
