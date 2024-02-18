package racinggame;

import java.io.IOException;
import racinggame.domain.MoveCondition;
import racinggame.domain.RandomMoveCondition;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Main {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveCondition moveCondition = new RandomMoveCondition();
        Controller controller = new Controller(inputView, outputView);

        controller.run(moveCondition);
    }
}
