package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingGameController;
import racingcar.view.InputParser;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(inputView(), outputView());
        racingGameController.run();
        clean();
    }

    private static InputView inputView() {
        return new InputView(inputValidator(), inputParser(), scanner);
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static InputParser inputParser() {
        return new InputParser();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static void clean() {
        scanner.close();
    }
}
