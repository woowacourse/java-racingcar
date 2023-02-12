package racing;

import java.io.IOException;

import racing.controller.RacingGameController;

public class Application {

    public static void main(String[] args) throws IOException {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.run();
    }
}
