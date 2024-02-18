package controller;

import domain.Cars;
import domain.MoveCount;
import dto.GameResultDto;
import java.util.List;
import service.RaceGameService;
import util.StringParser;
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
        Cars cars = prepareCars();
        MoveCount moveCount = prepareMoveCount();
        GameResultDto gameResultDto = raceGameService.runRaceGame(cars, moveCount);
        outputView.printRaceResult(gameResultDto);
    }

    private Cars prepareCars() {
        try {
            String name = inputView.requestCarName();
            List<String> carNames = StringParser.split(name, CAR_NAMES_DELIMITER);
            return Cars.from(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return prepareCars();
        }
    }

    private MoveCount prepareMoveCount() {
        try {
            Integer count = StringParser.parseToInt(inputView.requestMoveCount());
            return MoveCount.from(count);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return prepareMoveCount();
        }
    }
}
