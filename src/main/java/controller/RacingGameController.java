package controller;

import domain.Cars;
import domain.MoveCount;
import dto.GameResultDto;
import service.RaceGameService;
import util.Repeater;
import view.InputMapper;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceGameService raceGameService;
    private final InputMapper inputMapper;

    public RacingGameController(InputView inputView, OutputView outputView, RaceGameService raceGameService,
                                InputMapper inputMapper) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceGameService = raceGameService;
        this.inputMapper = inputMapper;
    }

    public void run() {
        Cars cars = Repeater.repeatUntilNoException(this::prepareCars);
        MoveCount moveCount = Repeater.repeatUntilNoException(this::prepareMoveCount);

        GameResultDto gameResultDto = raceGameService.runRaceGame(cars, moveCount);
        outputView.printRaceResult(gameResultDto);
    }

    private Cars prepareCars() {
        String carNames = inputView.requestCarNames();
        return inputMapper.mapToCars(carNames);
    }

    private MoveCount prepareMoveCount() {
        String count = inputView.requestMoveCount();
        return inputMapper.mapToMoveCount(count);
    }
}
