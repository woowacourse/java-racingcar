package view.input;

public class InputValidator {

    private static final int MIN_GAME_TRY_RANGE = 1;
    private static final int MAX_GAME_TRY_RANGE = 10000;

    private static final String GAME_TRY_COUNT_OUT_OF_RANGE = "[ERROR] 시도 횟수가 1번 이상 10000번 이하여야 합니다.";
    private static final String IS_NOT_INTEGER = "[ERROR] 정수 이외의 다른 문자를 입력해서는 안됩니다.";

    public void validateGameTryRange(String gameTry) {
        validateIsInteger(gameTry);
        validateGameTryRange(Integer.parseInt(gameTry));
    }

    private void validateIsInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_INTEGER);
        }
    }
    private void validateGameTryRange(int gameTry) {
        if (gameTry < MIN_GAME_TRY_RANGE || gameTry > MAX_GAME_TRY_RANGE) {
            throw new IllegalArgumentException(GAME_TRY_COUNT_OUT_OF_RANGE);
        }
     }
}
