package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.dto.TryCountRequest;
import racingcar.service.RacingCarService;
import racingcar.service.RandomMoveStrategy;
import racingcar.service.TryCount;
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
        TryCount tryCount = new TryCount(getTryCount());
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

    private int getTryCount() {
        TryCountRequest tryCountRequest = receiveTryCount();
        return tryCountRequest.getTryCount();
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
        for (int i = 0; i < tryCount.getCount(); i++) {
            racingCarService.moveCars(randomMoveStrategy);
            printCarStatuses();
        }
        printCarStatuses();
        findWinners();
    }

    private void findWinners() {
        try {
            RacingCarWinnerResponse racingCarWinnerResponse = racingCarService.findWinners();
            racingCarView.printWinners(racingCarWinnerResponse);
        } catch (RuntimeException e) {
            racingCarView.printExceptionMessage(e);
        }
    }

    private void printCarStatuses() {
        List<RacingCarStatusResponse> carStatuses = racingCarService.getCarStatuses();
        racingCarView.printRacingProgress(carStatuses);
    }
}
