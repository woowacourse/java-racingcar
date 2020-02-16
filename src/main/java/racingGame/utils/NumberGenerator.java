package racingGame.utils;

public class NumberGenerator {
    private NumberGenerateStrategy numberGenerateStrategy;

    public int generate() {
        return numberGenerateStrategy.generateNumber();
    }

    public void setNumberGenerateStrategy(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }
}
