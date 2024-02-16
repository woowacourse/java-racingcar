package domain;

public class MoveCount {

    private Integer moveCount;

    private MoveCount(Integer moveCount) {
        validate(moveCount);
        this.moveCount = moveCount;
    }

    public static MoveCount from(int moveCount) {
        return new MoveCount(moveCount);
    }

    public void consume() {
        moveCount--;
    }

    public boolean isCountZero() {
        return 0 == moveCount;
    }

    public void validate(int moveCount) {
        validateRange(moveCount);
    }

    private void validateRange(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 자동차의 전체 이동 횟수는 0이나 음수일 수 없습니다.");
        }
    }
}
