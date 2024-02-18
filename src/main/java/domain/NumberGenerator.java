package domain;


@FunctionalInterface
public interface NumberGenerator {
    int generate(int minNumber, int maxNumber);
}
