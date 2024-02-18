package controller;

import domain.Cars;
import domain.MoveCount;
import dto.GameResultDto;
import service.RaceGameService;
import util.Repeater;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private static final String CAR_NAMES_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceGameService raceGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RaceGameService raceGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceGameService = raceGameService;
    }

    public void run() {
        Cars cars = Repeater.repeatUntilNoException(inputView::requestCars);
        MoveCount moveCount = Repeater.repeatUntilNoException(inputView::requestMoveCount);
        GameResultDto gameResultDto = raceGameService.runRaceGame(cars, moveCount);
        outputView.printRaceResult(gameResultDto);
    }
}
