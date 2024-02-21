package domain;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_BOUNDARY_NUMBER = 4;

    @Override
    public boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
