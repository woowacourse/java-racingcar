package service;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return startInclusive + (int) (Math.random() * endInclusive);
    }
}
