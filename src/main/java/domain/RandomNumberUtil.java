package domain;

public class RandomNumberUtil implements NumberGenerator {
    @Override
    public int generator() {
        return (int) (Math.random() * 10);
    }
}
