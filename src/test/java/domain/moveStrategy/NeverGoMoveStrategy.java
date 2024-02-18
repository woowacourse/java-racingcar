package domain.moveStrategy;

public class NeverGoMoveStrategy implements MoveStrategy {

    @Override
    public boolean canGo() {
        return false;
    }
}
