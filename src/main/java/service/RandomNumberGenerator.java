package service;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return (int) (Math.random() * 9);
    }
}
