package racingcar;

public class FixedNumberGeneratingStrategy implements NumberGeneratingStrategy {

    @Override
    public int generateNumber() {
        return Rule.DRIVE_MAXIMUM_VALUE;
    }
}
