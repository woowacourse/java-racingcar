package application.racing.domain;

public class RacingLab {
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
            throw new IllegalArgumentException("숫자를 입력하십시오.");
        }
    }

    private void validateRacingLabUnderZero() {
        if (this.racingLab < RACING_LAB_STANDARD) {
            throw new IllegalArgumentException("0 이상의 수를 입력하십시오.");
        }
    }

    public int getRacingLab() {
        return this.racingLab;
    }
}
