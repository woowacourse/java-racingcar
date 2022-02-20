package racingcar.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import racingcar.dto.RequestAttemptDto;
import racingcar.dto.RequestCarsDto;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Cars;
import util.StringUtil;

public class InputView {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값이 없습니다.";
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String CAR_NAME_DELIMITER = ",";

    private Scanner scanner = new Scanner(System.in);

    public RequestCarsDto requestCars() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        String[] carNames = StringUtil.split(readNextLine(), CAR_NAME_DELIMITER);
        Cars cars = new Cars(carNames);
        return new RequestCarsDto(cars);
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
            throw new NoSuchElementException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }
}
