package racingcargame.utils;

public class NameInputValidator {

    private NameInputValidator() {
    }

    public static boolean validateCarNames(String carNames) {
        if (hasNotBlankInCarNames(carNames)) {
            return true;
        }
        return false;
    }

    private static boolean hasNotBlankInCarNames(String carNames) {
        return carNames == null;
    }
}
