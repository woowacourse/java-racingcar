package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;

public class OutputView {
    private static final String WINNER_DESCRIPTION = "가 최종 우승했습니다.";
    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String NO_WINNER_DESCRIPTION = "최대 이동 거리가 0이므로 우승한 자동차가 없습니다.";
    private static final String NAME_INPUT_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_INPUT_DESCRIPTION = "시도할 회수는 몇회인가요?";

    public static void println() {
        System.out.println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printResultDescription() {
        println();
        println(RESULT_DESCRIPTION);
    }

    public static void printPosition(CarGroup carGroup) {
        println(carGroup.toString());
    }

    public static void printException(String message) {
        println(message);
    }

    public static void printWinnerList(List<Car> winnerGroup) {
        List<String> names = winnerGroup.stream()
                .map(Car::getName)
                .toList();

        String winnerNames = String.join(", ", names);
        println(winnerNames + WINNER_DESCRIPTION);
    }

    public static void printNoWinner() {
        println(NO_WINNER_DESCRIPTION);
    }

    public static void printlnInputName() {
        println(NAME_INPUT_DESCRIPTION);
    }

    public static void printlnInputMoveCount() {
        println(MOVE_COUNT_INPUT_DESCRIPTION);
    }
}
