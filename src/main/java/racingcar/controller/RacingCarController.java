package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.round.Round;
import racingcar.dto.RacingRecord;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService service;

    public RacingCarController(InputView inputView, OutputView outputView,
        RacingCarService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        Cars cars = Cars.create(inputView.inputCarNames());
        Round round = new Round(inputView.inputRoundNumber());
        startRacing(cars, round);
    }

    private void startRacing(Cars cars, Round round) {
        List<RacingRecord> racingRecords = new ArrayList<>();
        while (!service.isEnd(round)) {
            racingRecords.add(service.run(cars, round));
        }
        outputView.printRacingRecords(racingRecords);
        outputView.printWinners(service.getWinners(cars));
    }
}
