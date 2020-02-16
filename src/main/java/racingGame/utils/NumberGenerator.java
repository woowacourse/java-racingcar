package racingGame.utils;

public class NumberGenerator {
    private NumberGenerateStrategy numberGenerateStrategy;

    public NumberGenerator(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public int generate() {
        return numberGenerateStrategy.generateNumber();
    }
}
