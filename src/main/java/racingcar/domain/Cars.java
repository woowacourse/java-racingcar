package racingcar.domain;

import java.util.Collection;

import racingcar.domain.strategy.MoveStrategy;

public interface Cars {
    void moveCars(MoveStrategy moveStrategy);

    Collection<Car> getCars();

    Collection<Car> getCarsInPosition(int position);

    int getMaxPosition();
}
