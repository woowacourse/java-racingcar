package domain;

public class RandomNumberGenerator implements NumberGenerator{

    public int generate() {
        return (int) (Math.random() * 10);
    }
}
