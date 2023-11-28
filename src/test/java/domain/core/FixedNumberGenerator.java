package domain.core;

public class FixedNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 10;
    }
}
