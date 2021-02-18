package racingcar.domain.move;

public class FixMoveStrategy implements MoveStrategy {

    private final int fixCriteria;

    public FixMoveStrategy(int fixCriteria) {
        this.fixCriteria = fixCriteria;
    }

    @Override
    public int getCriteria() {
        return this.fixCriteria;
    }
}
