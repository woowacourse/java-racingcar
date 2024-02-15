package racingcar.mock;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.move.MovingStrategy;

public class MockMovingStrategy implements MovingStrategy {
    private final List<Boolean> movableList;
    private int currentIndex = 0;

    public MockMovingStrategy(List<Boolean> movableList) {
        this.movableList = new ArrayList<>(movableList);
    }

    public MockMovingStrategy() {
        this.movableList = new ArrayList<>();
    }

    @Override
    public boolean canMove() {
        if (currentIndex >= movableList.size()) {
            throw new IllegalStateException("더 이상 이동할 수 없습니다.");
        }
        return movableList.get(currentIndex++);
    }

}
