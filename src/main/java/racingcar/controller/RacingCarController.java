package racingcar.controller;

import java.util.List;
import racingcar.domain.TryCount;
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
        createCar();
        TryCount tryCount = getTryCount();
        playGame(tryCount);
    }

    private void createCar() {
        RacingCarNamesRequest racingCarNamesRequest = receiveCarNames();
        racingCarService.createCars(racingCarNamesRequest);
    }

    private RacingCarNamesRequest receiveCarNames() {
        try {
            return racingCarView.receiveCarNames();
        } catch (RuntimeException e) {
            racingCarView.printExceptionMessage(e);
            return receiveCarNames();
        }
    }

    private TryCount getTryCount() {
        TryCountRequest tryCountRequest = receiveTryCount();
        return new TryCount(tryCountRequest.getTryCount());
    }

    private TryCountRequest receiveTryCount() {
        try {
            return racingCarView.receiveTryCount();
        } catch (RuntimeException e) {
            racingCarView.printExceptionMessage(e);
            return receiveTryCount();
        }
    }

    private void playGame(TryCount tryCount) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        racingCarView.printStartMessage();
        while (tryCount.countdown()) {
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
