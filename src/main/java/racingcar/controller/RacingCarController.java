package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingRecord;
import racingcar.dto.CarsResponse;
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
        List<RacingRecord> racingRecords = new ArrayList<>();
        while (!service.isEnd()) {
            racingRecords.add(service.run());
        }
        outputView.printRacingRecords(racingRecords);
        outputView.printWinners(service.getWinners());
    }

    private RacingCarService createRacingService() {
        String[] carNames = inputView.inputCarNames();
        int roundNumber = inputView.inputRoundNumber();
        return new RacingCarService(carNames, roundNumber);
    }
}
