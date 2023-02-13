import racing.CarFactory;
import racing.controller.RacingController;
import racing.domain.Cars;
import racing.ui.input.InputView;
import racing.ui.output.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(getCars());
        int count = Integer.parseInt(InputView.inputCount());
        racingController.start(count);
    }

    private static Cars getCars() {
        List<String> carNames = Arrays.asList(InputView.inputCarsName().split(OutputView.COMMA));
        return CarFactory.carFactory(carNames);
    }
}