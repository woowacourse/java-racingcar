package racingcar.domain;

public class FixedNumber implements NumberGenerator {
    @Override
    public int generateNumber() {
        return 5;
    }
}
