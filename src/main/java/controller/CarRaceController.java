package controller;

import dto.InputValidationRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.CarRaceService;
import type.ValidationType;
import validation.InputValidationChain;
import view.InputView;
import view.OutputView;

public class CarRaceController {

    private static final String CAR_NAME_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationChain validator;
    private final CarRaceService carRaceService;

    public CarRaceController(InputView inputView, OutputView outputView,
        InputValidationChain validator, CarRaceService carRaceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.carRaceService = carRaceService;
    }

    public void start() {
        move(saveCar(), requestCarMoveCount());
        outputView.printWinner(carRaceService.getResult());
    }

    private Map<String, Integer> saveCar() {
        String cars = inputView.requestCarName();
        validator.validate(new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE), cars));
        return carRaceService.saveCars(
            Arrays.stream(cars.split(CAR_NAME_DELIMITER)).collect(Collectors.toList()));
    }

    private int requestCarMoveCount() {
        String moveCount = inputView.requestMoveCount();
        validator.validate(new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE,
            ValidationType.NUMBER_RANGE, ValidationType.POSITIVE_NUMBER), moveCount));
        return Integer.parseInt(moveCount);
    }

    private void move(Map<String, Integer> initialCarStatus, int moveCount) {
        outputView.printInitialStatus(initialCarStatus);
        for (int count = 0; count < moveCount; count++) {
            outputView.printMoveResult(carRaceService.move());
        }
    }

}
