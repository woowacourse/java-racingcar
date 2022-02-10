package racingcar;

public class MoveCountValidator {

    public static void validateMoveCount(String moveCount) {
        checkInteger(moveCount);
        checkPositiveInteger(moveCount);
    }

    private static void checkInteger(String moveCount) {
        try {
            Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 이동횟수는 숫자로 입력해야합니다.");
        }
    }

    private static void checkPositiveInteger(String moveCount) {
        if (Integer.parseInt(moveCount) <= 0) {
            throw new IllegalArgumentException("[ERROR] 이동횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
