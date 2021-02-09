package racingcar.service;


import racingcar.domain.Cars;
import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService implements GameService {
    private RacingGame racingGame;

    @Override
    public void setUpGame(List<String> userNames, int goalRound) {
        racingGame = new RacingGame(userNames, goalRound);
    }

    @Override
    public void setUpGame(Cars users, int goalRound) {
        racingGame = new RacingGame(users, goalRound);
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

    @Override
    public boolean isEnd() {
        return racingGame.isEnd();
    }
}
