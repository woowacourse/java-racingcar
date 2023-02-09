package racingcar.util;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

import static racingcar.enumType.InputMessage.GET_CAR_NAMES_MESSAGE;
import static racingcar.enumType.InputMessage.GET_TRY_COUNT_MESSAGE;

public class InputUtil {

    private final InputView inputView = new InputView();

    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }

    public Cars getCarNames() {
        OutputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
        String carNames = inputView.getUserInput();
        return Cars.of(carNames);
    }

    public Race getTryCount() {
        OutputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
        String tryCount = inputView.getUserInput();
        return Race.of(tryCount);
    }
}
