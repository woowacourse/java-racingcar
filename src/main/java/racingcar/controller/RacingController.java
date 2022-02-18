package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.CarDto;
import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.view.InputView.ConsoleInputView;
import racingcar.view.OutputView.ConsoleOutputView;
import racingcar.view.OutputView.OutputView;

import java.util.List;

public class RacingController {
    private final OutputView outputView;

    public RacingController(ConsoleOutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        Game game = new Game(new ConsoleInputView(), new DetermineMovementByRandomNumber());
        outputView.printResultMessage();

        while(game.isContinue()) {
            game.carsMove();
            outputView.printRoundStatus(convertToDto(game.now()));
        }
        outputView.printWinners(convertToDto(game.winnerCars()));
    }

    private List<CarDto> convertToDto(List<Car> cars){
        return CarDto.toDtoList(cars);
    }
}
