package racingcar.util;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

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
        String carNames = inputView.getUserInput();
        return Cars.of(carNames);
    }
}
