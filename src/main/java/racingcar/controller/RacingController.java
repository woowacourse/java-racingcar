package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.CarDto;
import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.view.InputView.ConsoleInputView;
import racingcar.view.InputView.InputView;
import racingcar.view.OutputView.ConsoleOutputView;
import racingcar.view.OutputView.OutputView;

import java.util.List;

public class RacingController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingController(ConsoleOutputView outputView, ConsoleInputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public Game gameSet(){
        List<String> inputCarNames = inputView.inputCarNames();
        int inputTrialCount = inputView.inputTrialCount();
        return new Game(inputCarNames,inputTrialCount,new DetermineMovementByRandomNumber());
    }

    public void run() {
        Game game = gameSet();
        outputView.printResultMessage();

        while (game.isContinue()) {
            game.playOneSet();
            outputView.printRoundStatus(convertToDto(game.now()));
        }

        outputView.printWinners(convertToDto(game.winnerCars()));
    }

    private List<CarDto> convertToDto(List<Car> cars) {
        return CarDto.toDtoList(cars);
    }
}
