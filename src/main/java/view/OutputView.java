package view;

import vo.Name;
import vo.Result;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(Result result) {
        result.forEach(((name, position) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < position.getValue(); i++) {
                stringBuilder.append("-");
            }
            System.out.printf("%s : %s", stringBuilder, name.getValue());
        }));
        System.out.println();
    }

    public void printWinners(List<Name> winners) {
        List<String> carNames = winners.stream().map(Name::getValue).collect(Collectors.toList());
        String winnersName = String.join(", ", carNames);
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
