package racingcar.view;

import static racingcar.input.utils.carname.CarNamesSplitterUtils.CAR_NAMES_DELIMITER;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String POSITION_SIGN = "-";

    public static void printRaceResult() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void printRaceResultEachCar(String name, int currentPosition) {
        System.out.print(name + " : ");

        for (int i = 0; i < currentPosition; i++) {
            System.out.print(POSITION_SIGN);
        }

        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(List<String> names) {
        System.out.print("최종 우승자 : ");

        System.out.println(String.join(CAR_NAMES_DELIMITER + " ", names));
    }
}
