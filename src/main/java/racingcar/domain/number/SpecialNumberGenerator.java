package racingcar.domain.number;

public class SpecialNumberGenerator implements NumberGenerator {
    private final int specialNumber;

    public SpecialNumberGenerator(final int specialNumber) {
        this.specialNumber = specialNumber;
    }

    @Override
    public int generate() {
        return specialNumber;
    }
}
