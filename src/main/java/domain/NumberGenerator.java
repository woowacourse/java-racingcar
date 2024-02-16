package domain;

@FunctionalInterface
public interface NumberGenerator {
    int generateRangeOf(int minRange, int maxRange);
}
