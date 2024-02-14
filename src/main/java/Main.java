import controller.RacingCarController;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new RacingCarController(new InputView(), new OutputView()).run();
    }
}
