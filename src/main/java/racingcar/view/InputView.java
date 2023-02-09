package racingcar.view;

import racingcar.view.dto.CarNames;
import racingcar.view.dto.TrialTimes;

import java.util.Scanner;

public class InputView {
    private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String GET_TRY_TIME_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public CarNames getCarNames() {
        System.out.println(GET_CAR_NAME_MESSAGE);
        return new CarNames(scanner.nextLine());
    }

    public TrialTimes getTrialTimes() {
        System.out.println(GET_TRY_TIME_MESSAGE);
        return new TrialTimes(scanner.nextLine());
    }
}
