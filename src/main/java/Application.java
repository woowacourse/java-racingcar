import controller.RacingCarController;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarController racingCarController = new RacingCarController(racingCarService, inputView, outputView);

        racingCarController.run();
    }

}
