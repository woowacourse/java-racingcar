package racinginterface;

import racingcargame.model.Car;

import java.util.List;

public interface OutputViewInterface {
    void printRound(List<Car> carList);

    void printGameResult(List<String> winnerList);
}
