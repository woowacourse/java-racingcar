package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RacingCarController controller = new RacingCarController(inputView, outputView);
        controller.run();
    }
}
