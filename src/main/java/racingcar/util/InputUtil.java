package racingcar.util;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.exception.ConsoleException;
import racingcar.exception.DuplicateException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

import java.util.List;


public class InputUtil {

    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final InputView inputView = new InputView();

    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (ConsoleException e) {
            OutputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }

    public List<String> getCarNames() {
        OutputView.printMessage(GET_CAR_NAMES_MESSAGE);
        return inputView.readCarNames();
    }

    public int getTryCount() {
        OutputView.printMessage(GET_TRY_COUNT_MESSAGE);
        return inputView.readTryCount();
    }
}
