package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.dto.TryCountRequest;
import racingcar.service.RacingCarService;
import racingcar.service.RandomMoveStrategy;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void start() {
        RacingCarNamesRequest racingCarNamesRequest = racingCarView.receiveCarNames();
        racingCarService.createCars(racingCarNamesRequest);
        TryCountRequest tryCountRequest = racingCarView.receiveTryCount();
        int tryCount = tryCountRequest.getTryCount();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        racingCarView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            racingCarService.moveCars(randomMoveStrategy);
            printCarStatuses();
        }
        printCarStatuses();
        RacingCarWinnerResponse racingCarWinnerResponse = racingCarService.findWinners();
        racingCarView.printWinners(racingCarWinnerResponse);
    }

    private void printCarStatuses() {
        List<RacingCarStatusResponse> carStatuses = racingCarService.getCarStatuses();
        racingCarView.printRacingProgress(carStatuses);
    }
}
