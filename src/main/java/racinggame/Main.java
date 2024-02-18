package racinggame;

import java.io.IOException;
import racinggame.domain.RandomMoveCondition;
import racinggame.view.InputView;
import racinggame.view.OutputView;

class Main {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ObjectMapper objectMapper = new ObjectMapper();
        Controller controller = new Controller(inputView, outputView, objectMapper);

        controller.run(new RandomMoveCondition());
    }
}
