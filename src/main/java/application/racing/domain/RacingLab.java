package application.racing.domain;

public class RacingLab {
    private final static String ERR_MESSAGE_FOR_NOT_NUMBER = "숫자를 입력하십시오.";
    private final static String ERR_MESSAGE_FOR_UNDER_ZERO = "0 이상의 수를 입력하십시오.";
    private final static int RACING_LAB_STANDARD = 0;

    private int racingLab;

    public RacingLab(String input) {
        validateRightNumber(input);
        validateRacingLabUnderZero();
    }

    private void validateRightNumber(String input) {
        try {
            this.racingLab = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_NOT_NUMBER);
        }
    }

    private void validateRacingLabUnderZero() {
        if (this.racingLab < RACING_LAB_STANDARD) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_UNDER_ZERO);
        }
    }

    public int getRacingLab() {
        return this.racingLab;
    }
}
