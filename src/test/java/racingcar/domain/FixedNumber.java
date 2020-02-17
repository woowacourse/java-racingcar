package racingcar.domain;

public class FixedNumber implements NumberGenerator {

    @Override
    public boolean isMovable() {
        return true;
    }
}