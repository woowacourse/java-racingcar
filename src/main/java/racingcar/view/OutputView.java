package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String ENTER_TRIAL_NUMBER = "시도할 회수는 몇회인가요?\n";

    public static void readCarName() {
        System.out.print(ENTER_CAR_NAME);
    }

    public static void readTrialNumber() {
        System.out.print(ENTER_TRIAL_NUMBER);
    }

    public static void printCarInformation(final Car car) {
        System.out.println(car);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
