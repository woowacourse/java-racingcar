package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingGameController;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(inputView(), outputView());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView(inputValidator(), scanner());
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
