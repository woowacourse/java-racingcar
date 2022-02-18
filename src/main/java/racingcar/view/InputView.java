package racingcar.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import racingcar.domain.dto.RequestAttemptDto;
import racingcar.domain.dto.RequestCarsDto;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Cars;
import racingcar.view.enums.ViewErrorMessage;

public class InputView {

    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String CAR_NAME_DELIMITER = ",";

    private Scanner scanner = new Scanner(System.in);

    public RequestCarsDto requestCars() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        Cars cars = new Cars(splitNames(readNextLine()));
        return new RequestCarsDto(cars);
    }

    private String[] splitNames(String input) {
        return input.split(CAR_NAME_DELIMITER, -1);
    }

    public RequestAttemptDto requestAttempt() {
        System.out.println(REQUEST_ATTEMPT_MESSAGE);
        Attempt attempt = new Attempt(readNextLine());
        System.out.println();
        return new RequestAttemptDto(attempt);
    }

    private String readNextLine() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException(ViewErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.get());
        }
    }
}
