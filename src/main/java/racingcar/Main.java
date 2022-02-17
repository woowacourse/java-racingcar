package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        final InputView inputView = new InputView(new Scanner(System.in));
        final OutputView outputView = new OutputView();
        final RacingCarController controller = new RacingCarController(inputView, outputView);
        controller.run();
    }
}
