package racingcar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RacingCarController controller = new RacingCarController(inputView, outputView);
        controller.run();
    }
}
