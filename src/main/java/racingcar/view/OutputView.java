package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String POSITION_UNIT = "-";
    private static final String DELIMITER = ", ";

    public static void printStartRace() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printCarInfo(String name, int position) {
        System.out.println(name + " : " + toString(position));
    }

    private static String toString(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_UNIT);
        }
        return stringBuilder.toString();
    }

    public static void printPassOneLap() {
        System.out.println();
    }

    public static void printWinners(List<String> winnersName) {
        System.out.println(String.join(DELIMITER, winnersName) + "가 최종 우승했습니다.");
    }

}
