package racingCar.view;

import java.util.Scanner;
import racingCar.domain.dto.InitDto;
import racingCar.exception.NullInputException;

public class InputView {
    private static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String validate(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
        return inputString;
    }

    public InitDto getInitDto() {
        return InitDto.of(getInput(REQUEST_NAMES_MESSAGE), getInput(REQUEST_COUNT_MESSAGE));
    }

    private String getInput(String message) {
        System.out.println(message);
        return validate(scanner.next());
    }
}