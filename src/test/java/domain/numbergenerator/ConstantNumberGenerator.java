package domain.numbergenerator;

public class ConstantNumberGenerator implements NumberGenerator {
    private final int generatedValue;

    public ConstantNumberGenerator(int generatedValue) {
        this.generatedValue = generatedValue;
    }

    @Override
    public int generate() {
        return generatedValue;
    }
}
