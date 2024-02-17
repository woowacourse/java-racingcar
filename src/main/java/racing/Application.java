package racing;

import racing.controller.Controller;
import racing.view.InputView;
import racing.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.startGame();
    }
}
