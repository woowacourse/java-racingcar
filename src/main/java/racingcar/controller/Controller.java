package racingcar.controller;

import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.List;

public interface Controller {
    void setUpGame(List<String> names,int targetRound);
    CarsDto executeRound();
    WinnersDto findWinners();
}
