package racingcar.controller;

import racingcar.dto.RacingCarNamesRequest;
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
        for (int i = 0; i < tryCount; i++) {
            racingCarService.moveCars(randomMoveStrategy);
            racingCarView.printRacingResult();
        }
        RacingCarWinnerResponse racingCarWinnerResponse = racingCarService.findWinners();
        racingCarView.printWinners(racingCarWinnerResponse);
    }
}
