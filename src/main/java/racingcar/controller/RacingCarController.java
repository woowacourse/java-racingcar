package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingCarService service = createRacingService();
        startRacing(service);
    }

    private void startRacing(RacingCarService service) {
        outputView.printProcessPrompt();
        while (!service.isEnd()) {
            Cars result = service.run();
            outputView.printCarsPosition(result);
        }
        outputView.printWinners(service.getWinners());
    }

    private RacingCarService createRacingService() {
        String carNames = inputView.inputCarNames();
        String roundNumber = inputView.inputRoundNumber();
        return new RacingCarService(carNames, roundNumber);
    }
}
