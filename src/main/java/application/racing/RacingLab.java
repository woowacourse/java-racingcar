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
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    private void throwExceptionWhenNegativeRacingLabNumber() {
        if(this.racingLab < 0) {
            throw new IllegalArgumentException();
        }
    }
}
