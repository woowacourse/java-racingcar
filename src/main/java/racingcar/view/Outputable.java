package racingcar.view;

import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

public interface Outputable {
    void printLeaderBoard(CarsDto carsDto);

    void announceWinners(WinnersDto winnersDto);

    void printInputCarsNameMessage();

    void printInputNumberOfRoundsMessage();
}
