package calculator;

public class Add implements Operation {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
