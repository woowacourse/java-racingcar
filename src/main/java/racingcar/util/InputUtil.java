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

    private final OutputView outputView = new OutputView();

    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }

    public Cars getCarNames() {
        outputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
        String carNames = inputView.getUserInput();
        return Cars.of(carNames);
    }

    public Race getTryCount() {
        outputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
        String tryCount = inputView.getUserInput();
        return Race.of(tryCount);
    }
}
