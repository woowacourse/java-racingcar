package racingcar.domain;

public class GameRound {

    private static final int ZERO = 0;
    private int gameRound;

    int getGameRound() {
        return gameRound;
    }

    GameRound(String inputRound) {
        validateGameRound(inputRound);
        this.gameRound = Integer.parseInt(inputRound);
    }

    // 시도 횟수 오류검증
    private static void validateGameRound(String playRound) {
        if (!isValidGameRound(playRound)) {
            throw new IllegalArgumentException("음수 입력 불가합니다.");
        }
    }

    private static boolean isValidGameRound(String playRound) {
        try {
            return Integer.parseInt(playRound) > ZERO;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("1이상의 자연수만 입력 가능합니다.");
        }
    }
}
