package racinginterface;

import racingcargame.model.Car;

import java.util.List;

public interface ResultInterface {
    List<Car> roundResult();
    List<String> gameResult();
}
