package domain;

public class MoveCount {

    private static final Integer MIN_MOVE_COUNT = 1;

    private Integer moveCount;

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
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException("[ERROR] 이동 횟수는 1이상의 정수로 입력해주세요");
        }
    }

    public void consume() {
        moveCount--;
    }

    public boolean isCountZero() {
        return 0 == moveCount;
    }
}
