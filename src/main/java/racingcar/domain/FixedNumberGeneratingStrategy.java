package racingcar.domain;

public class FixedNumberGeneratingStrategy implements NumberGeneratingStrategy {

    @Override
    public int generateNumber() {
        return Rule.DRIVE_MAXIMUM_VALUE;
    }
}
