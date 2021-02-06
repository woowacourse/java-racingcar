package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Car;

public class OutputView {

    private static final String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String ENTER_TRIAL_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String OUTPUT_MESSAGE = "\n실행 결과\n";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.\n";

    public static void printCarNameReadMessage() {
        System.out.print(ENTER_CAR_NAME_MESSAGE);
    }

    public static void printAttemptNumberReadMessage() {
        System.out.print(ENTER_TRIAL_NUMBER_MESSAGE);
    }

    public static void printPlayResultMessage() {
        System.out.print(OUTPUT_MESSAGE);
    }

    public static void printCarInformation(final Car car) {
        System.out.println(car);
    }

    public static void printWinners(final ArrayList<Car> winners) {
        ArrayList<String> winnersNames = new ArrayList<String>();
        winners.stream()
            .forEach(it -> winnersNames.add(it.getCarName()));
        System.out.print(String.join(",", winnersNames) + WINNER_MESSAGE);
    }

    public static void printNewLine() {
        System.out.print(System.lineSeparator());
    }

}
