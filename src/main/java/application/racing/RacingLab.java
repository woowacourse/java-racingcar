package application.racing;

public class RacingLab {
    private int racingLab;

    public RacingLab(String input) {
        throwExceptionWhenCannotParsing(input);
        throwExceptionWhenNegativeRacingLabNumber();
    }

    private void throwExceptionWhenCannotParsing(String input) {
        try {
            this.racingLab = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력하십시오.");
        }
    }

    private void throwExceptionWhenNegativeRacingLabNumber() {
        if (isRacingLabUnderZero()) {
            throw new IllegalArgumentException("0 이상의 수를 입력하십시오.");
        }
    }

    private boolean isRacingLabUnderZero() {
        return this.racingLab < 0;
    }

    public int getRacingLab() {
        return this.racingLab;
    }
}
