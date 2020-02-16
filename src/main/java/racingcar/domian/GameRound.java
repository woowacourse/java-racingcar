package racingcar.domian;

public class GameRound {
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;

    private int gameRound;

    public GameRound(String gameRound) {
        this.gameRound = validateRound(gameRound);
    }

    public int getGameRound() {
        return gameRound;
    }

    private int validateRound(String inputRound) {
        validateNullOrEmpty(inputRound);
        int round = validateNumber(inputRound.trim());
        validateCount(round);
        return round;
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }

    private int validateNumber(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
        return count;
    }

    private void validateCount(int count) {
        if (count < COUNT_LOWER_LIMIT || count > COUNT_UPPER_LIMIT) {
            throw new IllegalArgumentException("횟수가 1보다 작거나 10번 초과입니다!");
        }
    }

}
