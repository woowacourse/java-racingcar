package view;

import vo.Name;
import dto.Result;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR = "[ERROR]";
    public static final String MOVING_RESULT_MESSAGE = System.lineSeparator() + "실행 결과";
    public static final String RESULT_MESSAGE_FORMAT = "%s : %s";
    public static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";
    public static final String DELIMITER = ", ";
    public static final String PROGRESS_BAR = "-";

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void printResultMessage() {
        System.out.println(MOVING_RESULT_MESSAGE);
    }

    public void printResult(Result result) {
        result.forEach(((name, position) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int count = 0; count < position.getValue(); count++) {
                stringBuilder.append(PROGRESS_BAR);
            }
            System.out.printf(RESULT_MESSAGE_FORMAT, stringBuilder, name.getValue());
        }));
        System.out.println();
    }

    public void printWinners(List<Name> winners) {
        List<String> carNames = winners.stream().map(Name::getValue).collect(Collectors.toList());
        String winnersName = String.join(DELIMITER, carNames);
        System.out.printf(WINNER_MESSAGE_FORMAT, winnersName);
    }
}
