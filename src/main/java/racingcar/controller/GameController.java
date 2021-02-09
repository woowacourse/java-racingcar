package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.List;

public interface GameController {
    void start();

    void setUpGame(List<String> names, int goalRound);

    void setUpGame(Cars cars, int goalRound);

    CarsDto progressRound();

    WinnersDto announceWinners();
}
