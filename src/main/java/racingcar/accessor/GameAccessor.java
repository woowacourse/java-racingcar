package racingcar.accessor;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.List;

public interface GameAccessor {
    void setUpGame(List<String> userNames, int goalRound);

    void setUpGame(Cars cars, int goalRound);

    CarsDto executeRound();

    WinnersDto findWinners();

    boolean isEnd();
}
