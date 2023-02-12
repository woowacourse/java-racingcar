package controller;

import dto.InputValidationRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.RacingGame;
import service.RandomNumberGenerator;
import type.ValidationType;
import validation.InputValidationChain;
import view.InputView;
import view.OutputView;

public class CarRaceController {

    private static final String CAR_NAME_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationChain validator;
    private RacingGame racingGame;

    public CarRaceController(InputView inputView, OutputView outputView,
        InputValidationChain validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void start() {
        move(startNewGame(), requestCarMoveCount());
        outputView.printWinner(racingGame.getResult());
    }

    private Map<String, Integer> startNewGame() {
        final String cars = inputView.requestCarName();
        validator.validate(new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE), cars));
        this.racingGame = createNewGame(cars);
        return racingGame.getCurrentStatus();
    }

    private int requestCarMoveCount() {
        final String moveCount = inputView.requestMoveCount();
        validator.validate(new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE,
            ValidationType.NUMBER_RANGE, ValidationType.POSITIVE_NUMBER), moveCount));
        return Integer.parseInt(moveCount);
    }

    private void move(final Map<String, Integer> initialCarStatus, final int moveCount) {
        outputView.printInitialStatus(initialCarStatus);
        for (int count = 0; count < moveCount; count++) {
            outputView.printMoveResult(racingGame.playTurn());
        }
    }

    private RacingGame createNewGame(final String cars) {
        return new RacingGame(
            Arrays.stream(cars.split(CAR_NAME_DELIMITER)).collect(Collectors.toList()),
            new RandomNumberGenerator());
    }

}
