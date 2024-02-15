public class Constant implements NumberGenerator {
    int generatedValue;
    public Constant(int generatedValue) {
        this.generatedValue = generatedValue;
    }

    @Override
    public int generate() {
        return generatedValue;
    }
}
