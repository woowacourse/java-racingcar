package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;

public class RacingCarView {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String RESULT_INDICATION_MESSAGE = "실행 결과\n";
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.\n";
    private static final String DASH = "-";
    private static final String VOID = "";
    private static final String POSITION_MESSAGE = "%s : %s\n";
    private static final int ZERO_VALUE = 0;

    public static String carListInput(Scanner scanner) {
        System.out.printf(INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static String turnNumberInput(Scanner scanner) {
        System.out.printf(TURN_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static void showResultMessage() {
        System.out.println();
        System.out.printf(RESULT_INDICATION_MESSAGE);
    }

    public static void displayPosition(Car car) {
        StringBuilder positionBuilder = new StringBuilder(VOID);
        for (int i = ZERO_VALUE; i < car.getPosition(); i++) {
            positionBuilder.append(DASH);
        }
        String position = positionBuilder.toString();
        System.out.printf(POSITION_MESSAGE, car.getName(), position);
    }

    public static void displayTurnInterval() {
        System.out.println();
    }

    public static void showWinner(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        String winnerShowMessage = winners + WIN_MESSAGE;
        System.out.printf(winnerShowMessage);
    }
}
