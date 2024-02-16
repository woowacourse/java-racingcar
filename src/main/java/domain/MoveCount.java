package domain;

public class MoveCount {

    public static final String ERROR_OF_MOVE_COUNT_RANGE = "[ERROR] 자동차의 전체 이동 횟수는 0이나 음수일 수 없습니다.";

    private Integer moveCount;

    private MoveCount(Integer moveCount) {
        validate(moveCount);
        this.moveCount = moveCount;
    }

    public static MoveCount from(int moveCount) {
        return new MoveCount(moveCount);
    }

    private void validate(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException(ERROR_OF_MOVE_COUNT_RANGE);
        }
    }

    public void consume() {
        moveCount--;
    }

    public boolean isCountZero() {
        return 0 == moveCount;
    }
}
