package view;

import java.util.List;

import domain.Winners;
import output.Output;
import output.Outputs;

public class OutputView {

    private static final String TITLE_MESSAGE = "\n실행 결과";
    private static final String PRINT_STATUS_FORMAT = "%s : %s\n";
    private static final String PRINT_WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String DELIMITER = ", ";
    private static final String DASH = "-";

    public static void printTitle() {
        System.out.println(TITLE_MESSAGE);
    }

    public static void printOutputs(Outputs outputs) {
        outputs.getOutputs()
                .forEach(OutputView::printOutput);
        System.out.println();
    }

    private static void printOutput(Output output) {
        String name = output.getName();
        int position = output.getPosition();

        String status = toDash(position);
        System.out.printf(PRINT_STATUS_FORMAT, name, status);
    }

    private static String toDash(int position) {
        return DASH.repeat(position);
    }

    public static void printWinners(Winners winners) {
        List<String> carNames = winners.getWinners();

        String winner = String.join(DELIMITER, carNames);
        System.out.printf(PRINT_WINNER_FORMAT, winner);
    }
}
