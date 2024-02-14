package domain;

public class RandomNumberGenerator {
    private static final Integer MIN = 0;
    private static final Integer MAX = 9;

    public Integer generate() {
        return (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }

}
