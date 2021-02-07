package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController implements Controller {
    private RacingGame racingGame;

    public void start() {
        CarsDto carDtos = InputView.getCarsName();
        List<String> carNames = carDtos.getCarDtoList().stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());

        int targetRound = InputView.getNumberOfRounds();
        racingGame = new RacingGame(carNames, targetRound);

        while (racingGame.isEnd()) {
            OutputView.printLeaderBoard(executeRound());
        }

        OutputView.announceWinners(findWinners());
    }

    @Override
    public void setUpGame(List<String> userNames, int goalRound) {
        racingGame = new RacingGame(userNames, goalRound);
    }

    public void setUpGame(Cars cars, int goalRound) {
        racingGame = new RacingGame(cars, goalRound);
    }

    @Override
    public CarsDto executeRound() {
        racingGame.playRound();
        Cars cars = racingGame.getCars();
        return cars.getCars()
                .stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), carDtos -> new CarsDto(carDtos, cars.getCurrentRound())));
    }

    @Override
    public WinnersDto findWinners() {
        GameResult winners = racingGame.findWinners();
        return new WinnersDto(winners.getWinnerNames(), winners.getWinnersPosition());
    }
}
