package controller;

import common.ExecuteContext;
import common.InputContext;
import domain.dto.InputValidationRequest;
import domain.model.Name;
import domain.service.CarRaceService;
import domain.type.ValidationType;
import domain.validation.InputValidationChain;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class CarRaceController {

    private static final String CAR_NAME_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationChain validator;
    private final CarRaceService carRaceService;
    private final InputContext inputContext;
    private final ExecuteContext executeContext;

    public CarRaceController(InputView inputView, OutputView outputView,
        InputValidationChain validator, CarRaceService carRaceService, InputContext inputContext,
        ExecuteContext executeContext) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.carRaceService = carRaceService;
        this.inputContext = inputContext;
        this.executeContext = executeContext;
    }

    public void start() {
        move(saveCar(), requestCarMoveCount());
        outputView.printWinner(carRaceService.getResult());
    }

    private Map<Name, Integer> saveCar() {
        return executeContext.workWithOptionStrategy(() -> {
            final String cars = getCarNames();
            return carRaceService.saveCars(
                Arrays.stream(cars.split(CAR_NAME_DELIMITER)).collect(Collectors.toList()));
        });
    }

    private String getCarNames() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            final String cars = inputView.requestCarName();
            validator.validate(
                new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE), cars));
            return cars;
        });
    }

    private int requestCarMoveCount() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            final String moveCount = inputView.requestMoveCount();
            validator.validate(new InputValidationRequest(List.of(ValidationType.EMPTY_VALUE,
                ValidationType.NUMBER_RANGE, ValidationType.POSITIVE_NUMBER), moveCount));
            return Integer.parseInt(moveCount);
        });
    }

    private void move(final Map<Name, Integer> initialCarStatus, final int moveCount) {
        outputView.printInitialStatus(initialCarStatus);
        for (int count = 0; count < moveCount; count++) {
            outputView.printMoveResult(carRaceService.move());
        }
    }


}
