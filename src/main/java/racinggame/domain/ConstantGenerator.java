package racinggame.domain;

public class ConstantGenerator implements NumberGenerator{
    private final int generatedConstant;

    public ConstantGenerator(int generatedConstant) {
        this.generatedConstant = generatedConstant;
    }

    public int generateNumber() {
        return generatedConstant;
    }
}
