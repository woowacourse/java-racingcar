package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(new Scanner(System.in)), new OutputView(),
                new RandomNumberGenerator());
        controller.run();
    }

}
