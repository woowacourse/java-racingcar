package domain;

public class MoveCount {

    private final Integer moveCount;

    private MoveCount(Integer moveCount) {
        validate(moveCount);
        this.moveCount = moveCount;
    }

    public static MoveCount from(int moveCount) {
        return new MoveCount(moveCount);
    }

    public void validate(int moveCount) {
        validateRange(moveCount);
    }

    private void validateRange(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException();
        }
    }
}
