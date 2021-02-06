package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {


    public void start() {
        CarsDto carDtos = InputView.getCarsName();
        List<String> carNames = carDtos.getCarDtoList().stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
        RacingGame racingGame = new RacingGame(carNames);

        executeRound(racingGame);
        CarsDto winners = racingGame.findWinners().getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), CarsDto::new));

        OutputView.announceWinners(winners);
    }

    private void executeRound(RacingGame racingGame) {
        int round = InputView.getNumberOfRounds();
        OutputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            Cars cars = racingGame.getCars();
            CarsDto roundResult = cars.getCars()
                    .stream()
                    .map(car -> new CarDto(car.getName(), car.getPosition()))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), CarsDto::new));
            OutputView.printLeaderBoard(roundResult);
        }
    }
}
