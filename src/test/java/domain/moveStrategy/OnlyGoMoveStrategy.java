package domain.moveStrategy;

public class OnlyGoMoveStrategy implements MoveStrategy {

    @Override
    public boolean canGo() {
        return true;
    }
}
