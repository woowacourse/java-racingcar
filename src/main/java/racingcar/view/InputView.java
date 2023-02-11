package racingcar.view;

import racingcar.view.dto.CarNamesRequest;
import racingcar.view.dto.TrialTimesRequest;

import java.util.Scanner;

public class InputView {
    private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_TIMES_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private static InputView inputView;

    private InputView() {}

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public CarNamesRequest getCarNames() {
        System.out.println(GET_CAR_NAME_MESSAGE);
        return new CarNamesRequest(scanner.nextLine());
    }

    public TrialTimesRequest getTrialTimes() {
        System.out.println(GET_TRY_TIMES_MESSAGE);
        return new TrialTimesRequest(scanner.nextLine());
    }
}
