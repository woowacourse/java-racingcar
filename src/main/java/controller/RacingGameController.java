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
        String carNames = inputView.requestCarNames();
        String count = inputView.requestMoveCount();

        Cars cars = Repeater.repeatUntilNoException(() -> inputMapper.mapToCars(carNames));
        MoveCount moveCount = Repeater.repeatUntilNoException(() -> inputMapper.mapToMoveCount(count));

        GameResultDto gameResultDto = raceGameService.runRaceGame(cars, moveCount);
        outputView.printRaceResult(gameResultDto);
    }
}
