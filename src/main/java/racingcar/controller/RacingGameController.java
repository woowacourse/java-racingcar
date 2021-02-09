package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.service.GameService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.Inputable;
import racingcar.view.OutputView;
import racingcar.view.Outputable;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController implements GameController {
    private final GameService gameService = new RacingGameService();
    private final Inputable inputable;
    private final Outputable outputable;

    /**
     * Outputable과 Inputable을 주입하지 않을 경우 default로 {@link OutputView} 와 {@link InputView} 를 생성합니다.
     */
    public RacingGameController() {
        this.inputable = new InputView();
        this.outputable = new OutputView();
    }

    public RacingGameController(Outputable outputable, Inputable inputable) {
        this.outputable = outputable;
        this.inputable = inputable;
    }

    @Override
    public void start() {
        List<String> carNames = getUserNames();

        setUpGame(carNames);

        iterateRounds();

        outputable.announceWinners(announceWinners());
    }

    private void setUpGame(List<String> carNames) {
        outputable.printInputNumberOfRoundsMessage();
        gameService.setUpGame(carNames, inputable.getNumberOfRounds());
    }

    private List<String> getUserNames() {
        outputable.printInputCarsNameMessage();
        return inputable.getCarsName()
                .getCarDtoList()
                .stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }

    private void iterateRounds() {
        while (!gameService.isEnd()) {
            outputable.printLeaderBoard(progressRound());
        }
    }

    @Override
    public void setUpGame(List<String> carNames, int goalRound) {
        gameService.setUpGame(carNames, goalRound);
    }

    @Override
    public void setUpGame(Cars cars, int goalRound) {
        gameService.setUpGame(cars, goalRound);
    }

    @Override
    public CarsDto progressRound() {
        return gameService.executeRound();
    }

    @Override
    public WinnersDto announceWinners() {
        return gameService.findWinners();
    }
}
