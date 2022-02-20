package racingcar;

import java.util.LinkedList;
import java.util.Queue;
import racingcar.constants.GameConstants;
import racingcar.domain.MoveStrategy;

public class StubMoveStrategy implements MoveStrategy {

    private int count;
    private final Queue<Integer> decisions = new LinkedList<>();

    public StubMoveStrategy(int count, int... decisions) {
        this.count = count;
        for (Integer decision : decisions) {
            this.decisions.add(decision);
        }
    }

    @Override
    public boolean canGo() {
        validateCountOverZero();
        minusOneCount();
        Integer poll = getOneByQueue();
        validateNull(poll);

        return poll >= GameConstants.CAN_GO_VALUE;
    }

    private Integer getOneByQueue() {
        return decisions.poll();
    }

    private void validateCountOverZero() {
        if (count < 0) {
            throw new AssertionError("스텁이 지정한 횟수를 초과했습니다.");
        }
    }

    private void validateNull(Integer number) {
        if (number == null) {
            throw new AssertionError("스텁 내의 decisions");
        }
    }

    private void minusOneCount() {
        count--;
    }

}
