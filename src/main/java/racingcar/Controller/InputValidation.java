package racingcar.Controller;

public class InputValidation {
    public static boolean isSmallerThanSix(String result) {
        if (result.isEmpty() || result.length() > 5) {
            return false;
        }
        return true;
    }
}
