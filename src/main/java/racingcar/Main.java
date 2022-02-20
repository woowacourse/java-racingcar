package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {

    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.run();
    }
}
