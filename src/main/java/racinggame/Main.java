package racinggame;

import racinggame.domain.RandomMoveCondition;
import racinggame.view.InputView;
import racinggame.view.OutputView;

class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ObjectMapper objectMapper = new ObjectMapper();
        Controller controller = new Controller(inputView, outputView, objectMapper);

        controller.run(new RandomMoveCondition());
    }
}
