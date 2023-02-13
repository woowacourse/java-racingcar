package racingcar;

import java.util.List;
import java.util.Scanner;
import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            OutputView outputView = new OutputView();
            InputView inputView = new InputView(scanner);
            outputView.startRacing();

            RacingcarService service = getService(inputView);
            RacingcarController controller = getController(service, outputView);

            int tryCount = getTryCount(inputView, outputView);

            controller.run(tryCount);
        }
    }

    private static int getTryCount(InputView inputView, OutputView outputView) {
        outputView.tryCount();

        return inputView.tryCount();
    }

    private static RacingcarController getController(RacingcarService service, OutputView outputView) {
        return new RacingcarController(outputView, service);
    }

    private static RacingcarService getService(InputView inputView) {
        try {
            List<String> carNames = inputView.carNames();

            return new RacingcarService(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return getService(inputView);
        }
    }
}
