package racingcar;

import java.util.InputMismatchException;
import java.util.List;
import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.doRacing();
    }

}

