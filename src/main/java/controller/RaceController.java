package controller;

import dto.RacingRoundStateDto;
import java.util.List;
import java.util.Set;
import service.RaceService;
import utils.RacingNumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void run(RacingNumberGenerator generator) {
        initCars();
        initRacingRound();
        race(generator);
        outputView.printWinners(raceService.calculateWinners());
    }

    private void initCars() {
        try {
            Set<String> carsName = inputView.inputCarsName();
            raceService.initCars(carsName);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            initCars();
        }
    }

    private void initRacingRound() {
        try {
            int round = inputView.inputRound();
            raceService.initRound(round);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            initRacingRound();
        }
    }

    private void race(RacingNumberGenerator generator) {
        outputView.printRoundStartMessage();

        List<RacingRoundStateDto> racingTotalState = raceService.race(generator);
        outputView.printRacingTotalState(racingTotalState);
    }
}
